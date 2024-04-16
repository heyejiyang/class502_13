package exam01;

import java.lang.invoke.SwitchPoint;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.id = 1234;
        s1.name ="김수한무거북이와두루미삼천갑자동방삭치치카포와리와리센타";
        s1.subject="도덕";
        s1.study();
        System.out.println(s1.id);

        Student s2 = new Student();
        s2.id = 1001;
        s2.name = "와다다";
        s2.subject="음악";
        s2.study();
    }

}
