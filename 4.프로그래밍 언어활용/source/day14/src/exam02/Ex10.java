package exam02;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Ex10 {
    public static void main(String[] args) {
        int[] scores = {60, 78, 90, 100, 87};

        //Arrays.stream(scores); //IntStream 형태로 반환
        IntSummaryStatistics stat = Arrays.stream(scores).summaryStatistics(); //통계기능

        double avg = stat.getAverage();
        long count = stat.getCount();
        int max = stat.getMax();
        int min = stat.getMin();
        long sum =stat.getSum();
        System.out.printf("평균: %f, 총 갯수: %d, 최대: %d, 최소: %d, 합계: %d%n",avg,count,max,min,sum);
        //평균: 83.000000, 총 갯수: 5, 최대: 100, 최소: 60, 합계: 415
    }
}
