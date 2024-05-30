package org.choongang;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) throws Exception { //수신
        //localhost
        Socket socket = new Socket("127.0.0.1", 9999);
        Scanner sc = new Scanner(System.in);


        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            while (true) {
                System.out.print("메시지: ");
                String message = sc.nextLine();

                //사용자 입력 메시지 서버에 보내기
                dos.writeUTF(message);
            }
        }
    }
}
