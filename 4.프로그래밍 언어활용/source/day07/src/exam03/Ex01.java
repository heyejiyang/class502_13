package exam03;

public class Ex01 {
    public static void main(String[] args) {
        try(Resources res = new Resources()){
            //res가 AutoClosable 인터페이스 구현 객체 인지 체크
            //-> 맞으면 close()메서드를 자동 호출
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
