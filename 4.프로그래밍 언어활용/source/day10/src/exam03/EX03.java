package exam03;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class EX03 {
    public static void main(String[] args) {
        Class cls = Ex02.class;

       // Annotation anno = cls.getAnnotation(MyAnno.class);
        MyAnno anno = (MyAnno) cls.getAnnotation(MyAnno.class);
        int min = anno.min();
        int max = anno.max();

        System.out.printf("min = %d, max = %d\n",min,max); //min = 10, max = 100
        String[] names = anno.names();
        System.out.println(Arrays.toString(names));

        String value = anno.value();
        System.out.println(value);
    }
}
