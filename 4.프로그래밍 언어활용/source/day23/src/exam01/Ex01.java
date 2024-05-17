package exam01;

public class Ex01 {
    public static void main(String[] args) {
        // + 호출스택 => 메인쓰레드 작업대1

        //두번째 방법
        //Runnable 인터페이스 -> 함수형 인터페이스, 람다
        Runnable r = () -> {
            for(int i = 0; i< 5; i++){
                System.out.println("쓰레드2-"+i);

                for(long j = 0; j < 10000000000L; j++);
            }
        };
        Ex01_1 th1 = new Ex01_1(); //상속을 통해서 만든 쓰레드
        Thread th2 = new Thread(r);

        //th1.run(); //작업대 2
        //th2.run(); //작업대 3
        th1.start(); //호출 스택 하나 생성 + run() 메서드 실행
        th2.start(); //호출 스택 하나 생성 + run() 메서드 실행
        System.out.println("작업종료!");
    }
}

//작업대 만드는 방법은 두가지
//첫번째 방법
class Ex01_1 extends Thread{
    public void run(){ //작업대
        for(int i = 0; i< 5; i++){
            System.out.println("쓰레드1-"+i);

            for(long j = 0; j < 10000000000L; j++);
        }

    }
}
