package exam03;

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 100;
        Integer num2 = Integer.valueOf(200); //원래 객체 자체는 연산이 안되기 때문에 컴파일러가 기본형으로 바꿔준다 자동으로 .intValue를 호출해줌

        //int result1 = num1 + num2.intValue();
        int result1 = num1 + num2;
        System.out.println(result1);

        Integer num3 = Integer.valueOf(40);
        Integer num4 = Integer.valueOf(6);
        int result2 = num3+num4;
        System.out.println(result2);
    }
}
