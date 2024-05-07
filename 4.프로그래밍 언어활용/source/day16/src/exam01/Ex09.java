package exam01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ex09 {
    public static void main(String[] args) {
        Student[] students = {
                new Student(1, "이길동",90),
                new Student(1, "김수환",40),
                new Student(2, "김수환",50),
                new Student(2, "나길동",70),
                new Student(2, "김수민",100),
                new Student(3, "김수환",70),
                new Student(3, "홍길동",60),
                new Student(3, "김이름",90),
        };
        Map<Boolean, List<Student>> data = Arrays.stream(students).collect(Collectors.partitioningBy(s -> s.getScore() >= 70));

        List<Student> students1 = data.get(true); // 70점 이상인 학생 목록
        students1.forEach(System.out::println);
        /*
        * Student{ban=1, name='이길동', score=90}
        Student{ban=2, name='나길동', score=70}
        Student{ban=2, name='김수민', score=100}
        Student{ban=3, name='김수환', score=70}
        Student{ban=3, name='김이름', score=90}
        * */
    }
}
