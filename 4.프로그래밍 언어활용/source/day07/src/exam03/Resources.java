package exam03;

public class Resources  implements AutoCloseable{ //자원해제가 필요한 클래스라 가정
    @Override
    public void close() throws Exception {
        System.out.println("자원해제!!");
    }
}
