package exam01;

public class RecCalculator implements Calculator {
    //재귀 방식의 구현체  - 프록시가 대신 수행해줄것
    @Override
    public long factorial(long num) {
        if(num < 1L){
            return 1L;
        }
        return num * factorial(num - 1);
    }

}
