package exam01;

public class Ex07 {
    public static void main(String[] args) {
        //int num1 = 10000000000;
        //long num1 = 10000000000; //애초에 int 범위를 던져주기때문에 int 범위에서 벗어난걸 캐치하면 오류먼저 출력해낸다
        long num1 = 1000000000000L; //int(4)
        // 가독성을 위해 _를 붙여주기도한다.
        long num3 = 10_000_000_000L;

        byte num2 = 100;//처음에 int를 던지고 아니면 바꿔준다 -> byte

        //float num4 = 100.123; double(8) -> float(4) 더 큰값을 작은 곳에 넣을 수 없다.
        float num5 = 100.123F; //F -> 처음부터 4바이트 float로 공간 할당
    }
}
