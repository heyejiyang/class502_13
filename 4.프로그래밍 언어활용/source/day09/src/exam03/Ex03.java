package exam03;

public class Ex03 {
    public static void main(String[] args) {
        String str = "    ";
        System.out.printf("str.isEmpty(): %s%n",str.isEmpty());//여백 미포함, 비어있는지 체크, 공백까지 없어야지 true
        //false
        System.out.printf("str.isBlank():%s%n",str.isBlank()); //여백 포함 체크, 공백 있어도 문자 없으면 true
        //true
    }
}
