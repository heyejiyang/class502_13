package ex07;

public class Outer {
    //    void method(){
//        class methodInner{
//            void method(){
//                System.out.println("지역 내부 클래스");
//            }
//        }
//        //지역에 정의된 클래스니 객체를 생성하고 활용해야한다
//        methodInner in = new methodInner();//지역 내부에서 객체를 만들고 사용
//        in.method();
//    }
    //2. 멤버 변수로 + 미구현메서드 구현체 정의
    public Calculator cal = new Calculator() {
        public int add(int num1, int num2) {
            return num1 + num2;
        }
    };
    Calculator method(int num3) {//지역변수
        return  new Calculator() { //return하면 자원해제
            public int add(int num1, int num2) {
                return num1 + num2 +num3;
            }
        };
    }
}
