package exam02;

public class Ex02 {
    public static void main(String[] args) {
        /*Calculator cal = new Calculator() { //인터페이스도 객체가 된다. 메서드 지역 내부 -> 미구현된 구현체 구현
            @Override
            public int add(int num1, int num2) {
                return num1+num2;
            }
        }; */
        //효율적으로 작성해보자

       /* Calculator cal = (num1, num2) -> {
                return num1+num2;
            };
        }

        */
        //자료형을 보고 어떤 인터페이스인지 알수있으니 생략 new Calculator()

        //인터페이스의 정의된 추상메서드를 보고 자료형, 함수명, 반환타입 다 인지하고 있다. 생략
        //대신 일부로 했다는 거를 표시해주기 위해 람다식 표현 '->' 해줘야함

        //한줄일때는 중괄호, return도 생략 가능( 반환값이 있는거 보고 return을 해줄것도 알고있음)
        //Calculator cal = (num1, num2) -> num1 + num2; // 변수명도 너무 길다.. 더줄이자..

        int c = 10;
        Calculator cal = (a, b) -> { //인터페이스 구현체
            //c = 20; // 지역변수 상수화 적용
            return a + b + c;
        };
        int result = cal.add(10, 20);
        System.out.println(result);

    }
}

