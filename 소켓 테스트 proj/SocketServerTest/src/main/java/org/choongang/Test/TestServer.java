package org.choongang.Test;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999); //동적포트 설정
        //클라이언트가 접속하려면 데이터를 주고받을수있는 포트가 필요하다.

        while (true){
            System.out.println("서버 대기중 ...");
            Socket socket = serverSocket.accept(); //클라이언트 접속 전 까지 대기 상태에 있다가 클라이언트 접속하면 연결해줌
            System.out.println("클라이언트 서버 접속: "+ socket);

            //클라이언트가 보낸 데이터를 받기 위한 inputStream(수신) 필요
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String str = dis.readUTF();
            System.out.println("클라이언트가 보낸 메시지: "+str);
        }
    }
}
