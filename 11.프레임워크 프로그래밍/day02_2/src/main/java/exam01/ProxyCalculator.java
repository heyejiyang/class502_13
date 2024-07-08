package exam01;

public class ProxyCalculator implements Calculator{

    // ImplCalculator, RecCalculator 대신 수행 해주려면 자료형은? => 다형성을 이용

    private Calculator calculator; // 다형성! 부모 인터페이스/ 열어 놓는 구조로 정의 직접 고정해서 정의하는것은 좋지 않다 ex) Calculator calculator = new ImplCalculator();

    //외부에서 주입받은 calculator 계산기를 가지고 연산을 대신 수행
    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public long factorial(long num) {

        long stime = System.nanoTime(); //공통기능
        try{
            //다른 계산기의 핵심기능을 대신 수행한다.
            long result = calculator.factorial(num); //다른 계산기의 factorial 연산을 대신 수행
            return result;

        }finally {
            long etime = System.nanoTime(); //공통 기능
            System.out.println("걸린시간: "+ (etime - stime));
        }
    }
}
