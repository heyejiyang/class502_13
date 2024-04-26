package exam03;

import java.lang.annotation.Annotation;

public class EX03 {
    public static void main(String[] args) {
        Class cls = Ex02.class;

       // Annotation anno = cls.getAnnotation(MyAnno.class);
        MyAnno anno = (MyAnno) cls.getAnnotation(MyAnno.class);
        int min = anno.min();
        int max = anno.max();

        System.out.printf("min = %d, max = %d\n",min,max); //min = 10, max = 100
    }
}
