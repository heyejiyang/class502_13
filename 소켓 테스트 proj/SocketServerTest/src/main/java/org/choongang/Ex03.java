package org.choongang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) throws Exception {
        //localhost
        Socket socket = new Socket("127.0.0.1", 9999);
        Scanner sc = new Scanner(System.in);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        Thread th = new Thread(() -> {
            try (DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()))) {
                while(true) {

                    String json = dis.readUTF();
                    System.out.println(json);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        th.start();

        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                System.out.print("메시지: ");
                String message = sc.nextLine();

                SocketData data = new SocketData("user03","request_users",message, LocalDateTime.now());

                String json = om.writeValueAsString(data);

                //사용자 입력 메시지 서버에 보내기
                dos.writeUTF(json); //객체를 문자열형태인 json으로 변환해서 전송
            }
        }
    }
}
