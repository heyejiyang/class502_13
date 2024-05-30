package org.choongang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.SocketHandler;
import java.util.stream.Collectors;

/*
 * ThreadPoolExecutor는 자바의 ExecutorService 인터페이스를 구현하는 클래스 중 하나로, 효율적으로 스레드를 관리하고 작업을 병렬로 처리할 수 있도록 합니다.
 * ThreadPoolExecutor는 스레드 풀을 사용하여 스레드를 재사용하고, 작업이 들어오면 즉시 사용 가능한 스레드가 해당 작업을 처리하게 합니다.
 * */
public class Server {
    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private ObjectMapper om;
    private Map<String, Socket> clients; //접속한 사용자(소켓)
    //키값은 사용자 명
    /*
    소켓 나눌때 방별로 하려면...
    Map<String,Map<String,Socket>> rooms = new HashMap<>();
    * */
    public Server() {
        try {
            //환경변수 port
            String _port = System.getenv("port");
            int port = _port == null || _port.isBlank() ? 9999 : Integer.parseInt(_port);

            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadPool = new ThreadPoolExecutor(2, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<>() {
        });
        /*
         * 최소 유지할 스레드 수 2개
         * 최대 허용할 스레드 수 100개
         * 생성된 스레드가 작업이 없는 상태에서 유지될 시간 120초
         * 120 -> 초단위 설정
         * 작업을 보관하는 큐, 큐에 저장되지 않고 작업이 즉시 실행될 수 있도록 스레드가 필요
         * */
        /*
        *1. 새로운 작업이 들어오면:
        corePoolSize보다 현재 스레드 수가 적으면 새로운 스레드를 생성하여 작업을 처리합니다. (큐 사용 x)
        * 현재 실행중인 스레드 수가 corePoolSize에 도달한 상태에서 새로운 작업이 들어오면 작업이 큐에 저장
        * workQueue는 작업을 대기열에 넣고, 풀에서 사용 가능한 스레드가 작업을 처리할 준비가 되면 큐에서 작업을 가져옴
        * 큐가 꽉 차면, 새로운 스레드를 생성하여 작업을 처리함
        * 이 때 생성되는 스레드는 maximumPoolSize를 넘지 않아야 한다.
        * ex) 예: corePoolSize가 2, maximumPoolSize가 5인 경우,
          2개의 스레드가 사용 중이고 작업 큐가 가득 차면, 최대 3개의 추가 스레드를 생성할 수 있습니다.
         */
        /*
        2. 작업이 완료되면:
        작업이 완료된 스레드는 다음 작업을 위해 대기 상태로 돌아간다.
        즉, 작업 큐에 저장된 다음 작업을 처리할 준비가 된다.
        - 스레드 제거
        corePoolSize를 초과하여 생성된 스레드는 keepAliveTime동안 추가 작업없으면 제거된다.
        keepAliveTime은 스레드가 작업이 없는 상태에서 유지될 최대의 시간을 의미, 시간이 지나면 스레드는 풀에서 제거됨
        * */

        om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        /* * ObjectMapper 클래스
         * 1. 자바객체 -> JSON 문자열로 바꿈 (setter)
         * String writeValueAsString(Object data)
         *
         * 2. JSON 문자열 -> 자바객체로 바꿈 (setter)
         * T readValue(String str, Class<T> class)
         *
         * */

        //처음 접속했을때 사용자 기억
        clients = new HashMap<>();
    }

    public void start() {
        //서버는 계속 대기상태

        //소켓 연결상태 모니터링 - 연결 끊겼을 경우 제거 -> 데몬쓰레드형태로 구현되어있음
        monitoring();

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                //서버 소켓을 생성하고 클라이언트의 연결을 기다린다.

                SocketHandler handler = new SocketHandler(socket);
                //클라이언트가 연결되면 SocketHandler 인스턴스가 생성되어 해당 소켓을 처리한다.


                //수신처리
                handler.input(data -> {
                    SocketData sData = toObject(data);

                    String from = sData.getFrom(); //보낸사람
                    //최초 접속인 경우, 사용자(소켓) 등록
                    if (!clients.containsKey(from)) {
                        clients.put(from, socket);
                    }

                    //전송
                    System.out.println(sData);
                    String to = sData.getTo();
                    handler.send(to, sData);

                    //System.out.println(sData);
                    //System.out.println(data);
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private SocketData toObject(String json) { //문자열을 자바객체로 변환
        SocketData data = null;
        try {
            data = om.readValue(json, SocketData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String toJSON(SocketData sData) {//자바객체를 json문자열로 변환
        String data = null;
        try {
            data = om.writeValueAsString(sData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

    /*
     * 소켓 연결이 종료된 경우 clients에서 제거
     * 5초마다 연결 상태 체크, 연결 종료된경우 제거
     * 정상적으로 종료되었을 경우 바로 제거됨
     * */
    //데몬쓰레드
    public void monitoring() {
        Thread th = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); //5초에 한번씩 체크해
                } catch (InterruptedException e) {
                }

                //map의 key와 value형태 가져옴
                //연결이 끊긴 경우 map에서 제거
                for (Map.Entry<String, Socket> client : clients.entrySet()) {
                    if (client.getValue().isClosed()) {
                        //연결 종료 상태인경우 제거
                        clients.remove(client.getKey());
                    }
                }
            }
        });
        th.setDaemon(true);
        th.start();
    }

    //클라이언트 소켓 처리
    class SocketHandler {
        //수신은 수신대로 발신은 발신대로 병렬적으로 수행해야한다.(동시다발적으로) -> 스레드 사용
        //직렬로 하게 되면 동시에 연결을 주고받을수 없게됨

        //클라이언트마다 연결된 소켓을 가지고 데이터를 연결하고 받는 스레드를...

        private Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        //수신처리
        public void input(Consumer<String> handler) { //수신된 데이터를 consumer 타입의 핸들러에 전달, 하나의 입력 매개변수를 받아서 처리하는 accept메서드 가짐
            threadPool.execute(() -> { //새로운 스레드 생성
                //데이터를 json문자열 형태로 받는다. 자원해제 필요
                try { //클라이언트로부터 데이터를 읽는다.
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    while (true) {
                        //소켓이 없거나 핸들러가 정의되어있지 않을때 수신받지 x
                        if (socket == null || socket.isClosed() || handler == null) {
                            // 빠르게 작업하기 위해 소켓이 없을 경우 다음 작업이 있는 스레드 에게 작업순서 넘기기
                            Thread.currentThread().yield();
                            break; //반복 멈춤
                        }

                        String data = dis.readUTF();
                        handler.accept(data);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        //발신 처리
        public void output(Socket toSocket, SocketData data) {
            //병렬적으로 작업
            if (toSocket == null || toSocket.isClosed() || data == null) {
                return;
            }
            threadPool.execute(() -> {
                try { //상대방쪽 소켓
                    DataOutputStream dos = new DataOutputStream(toSocket.getOutputStream());
                    String json = toJSON(data);
                    dos.writeUTF(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }

        /*
         * 메시지 전송
         * @param to
         * - all: 모든 접속자
         * - request_users: 모든 접속자 목록
         * - request_exit: 연결 종료, 소켓 close(), 소켓 제거
         * @param data
         * */
        public void send(String to, SocketData data) {

            data.setRegDt(LocalDateTime.now()); //전송할때마다 날짜와시간 보낸 시점으로 전송

            if (to.equals("all")) {//모든 사용자가 볼 수 있게 - 전체전송
                clients.values().forEach(s -> output(s, data));
            } else if (to.equals("request_users")) {//모든 접속자 목록 요청

                to = data.getFrom(); //요청 정보는 요청한 사용자에게 반송
                String message = clients.keySet().stream().collect(Collectors.joining("||")); //사용자 목록 ||로 나눠서 구분
                data.setMessage(message); //본인에게 다시 전송

                Socket s = clients.get(to);
                output(s,data);

            } else if (to.equals("request_exit")) { //접속 종료
                String from = data.getFrom();
                Socket s = clients.get(from); //본인꺼 가져옴
                if (s != null) {
                    if (!s.isClosed()) {
                        try {
                            s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    clients.remove(from);
                }
            } else { //특정 사용자 전송
                Socket s = clients.get(to);
                if (s != null) { //null이 아닐때만 전송
                    output(s, data);
                }
            }
        }

    }
}
