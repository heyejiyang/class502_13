package exam02;

import java.time.LocalDate;

public class CalEx {

    public static void main(String[] args) {
        //오늘 날짜
        LocalDate today = LocalDate.now();
        //년 월을 알고있으면 시작일자를 1로 고정
        LocalDate startDate = LocalDate.of(today.getYear(), today.getMonth(),1);

        int yoil = startDate.getDayOfWeek().getValue(); //요일의 값 가져오기 1(월) ~ 7(일)
        // 이거만큼 띄어주면 된다.
        System.out.println(yoil); // 3 // 5월1일은 수요일에 시작 -> 3만큼 띄어쓰기
        //요일을 0(일) ~ 6(토) -> yoil % 7


        //5월 1일에서 다음달로 넘어가고(6월1일) -1 하면 마지막 날짜나옴
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        System.out.println(endDate); //2024-05-31

    }

}
