package exam05;

public class Ex01 {
    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner in = out.new Inner(); //out에 주소 담고있음
        //외부클래스의 객체가 생성이 되어야지만 내부 클래스에 있는 자원을 객체로 만들어서 사용 가능해짐
        in.method();
    }
}
