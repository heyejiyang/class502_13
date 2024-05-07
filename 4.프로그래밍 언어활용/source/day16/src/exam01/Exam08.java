package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Exam08 {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "홍길동"),
                new Student(1, "김수환"),
                new Student(2, "김수환"),
                new Student(2, "홍길동"),
                new Student(2, "김수민"),
                new Student(3, "김수환"),
                new Student(3, "홍길동"),
                new Student(3, "김이름"),
        };

//        Map<Integer,String> data = Arrays.stream(students)
//                .collect(toMap(Student::getBan,Student::getName));

        Map<Integer, List<Student>> data = Arrays.stream(students)
                //.collect(Collectors.groupingBy(s -> s.getBan()));
                .collect(Collectors.groupingBy(Student::getBan));
        //그룹해서 가져올때

        List<Student> students2 = data.get(2); //2반 학생
        students2.forEach(System.out::println);
        /*Student{ban=2, name='김수환'}
        Student{ban=2, name='홍길동'}
        Student{ban=2, name='김수민'}*/

    }

    ;
}
