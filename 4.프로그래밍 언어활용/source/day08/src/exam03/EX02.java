package exam03;

public class EX02 {
    public static void main(String[] args) {
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10); //다른 주소의 객체 생성
        System.out.println(System.identityHashCode(num1));
        System.out.println(System.identityHashCode(num2));
        //값은 동일해서 10이란 숫자를 가지고 같은 역할을 수행하고 같은 결과를 출력하는데 이렇게 재료가 동일하고 처리되는 내용도 같은데 객체를 여러개 만든다는것은 매우 비효율적이다
        //-> valueOf사용하자
    }
    //1324119927
    //990368553
}
