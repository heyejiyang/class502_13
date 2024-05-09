package exam03;

import java.text.ChoiceFormat;

public class Ex05 {
    public static void main(String[] args) {
//        double[] limits = {60, 70, 80, 90};
//        String[] grades = {"D","C","B","A"};
//        ChoiceFormat cf = new ChoiceFormat(limits,grades);

        String pattern = "60#D|70#C|80<B|90#A";
        //81~90 -> B학점
        //70~80 -> C 학점

        ChoiceFormat cf = new ChoiceFormat(pattern);
        int[] scores = {100,70,55,80,95,87};
        for(int score: scores){
            String grade = cf.format(score);
            System.out.printf("점수: %d, 학점: %s%n", score, grade);
        }
        /*
        * 점수: 100, 학점: A
          점수: 70, 학점: C
          점수: 55, 학점: D
          점수: 80, 학점: B
          점수: 95, 학점: A
          점수: 87, 학점: B
        *
        * */
    }
}
