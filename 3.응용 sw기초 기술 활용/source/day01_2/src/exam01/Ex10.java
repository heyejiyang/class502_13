package exam01;

public class Ex10 {
    public static void main(String[] args) {
        int num1 = 1000000;
        //byte num2 = num1; // 큰 공간의 숫자 작은공간에 다 담지 못한다. 데이터 변질

        //그래도 굳이 굳이 담고싶다? -> 명시적 형변환
        byte num2 = (byte)num1;
        System.out.println(num2);
    }
}
