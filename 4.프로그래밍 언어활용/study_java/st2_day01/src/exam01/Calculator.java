package exam01;

public abstract class Calculator {
    //계산기에 필요한 설계 원칙을 정의해둠
    int num = 10;
    public abstract int add(int num1, int num2);
    public abstract int minus(int num1, int num2);

    public final void commonMethod(){// 하위클래스에 정의될 공통적인 메서드도 정의 가능
        System.out.println("공통 메서드");
    }

}
