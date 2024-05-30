package org.choongang.Test;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",9999);
        //소켓 서버 - 9999포트

        //클라이언트에서 소켓 서버쪽에 데이터 전송 (서버가 할당한 동적 포트를 통해서 주고받음)
        //outputStream(발신)
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        dos.writeUTF("안녕 서버야 ~ 난 클라이언트야"); //서버가 동적포트를 통해서 데이터를 받게된다.
    }
}
