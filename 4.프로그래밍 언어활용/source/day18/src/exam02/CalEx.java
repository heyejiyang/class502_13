package exam02;

import java.time.LocalDate;
import java.util.*;

public class CalEx {

    public static void main(String[] args) {
        //입력받는 부분 구현
        Scanner scan = new Scanner(System.in);
        //입력받는 문구
        String input = "";
        while (true){
            System.out.print("년 월 입력: ");
            input = scan.nextLine(); //2024 5 입력시 5월 달력 출력

            if(input.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            //입력받은 문자가 형식에 맞지 않을경우 예외처리
            try {
                String[] data = input.split("\\s+"); //년도와 월 쪼개기
                int year = Integer.parseInt(data[0]);//String을 숫자형식으로 바꿈
                int month = Integer.parseInt(data[1]);

                System.out.printf("----- %d년 %d월 -----%n",year,month); //달력 출력

                //요일 출력 칸
                System.out.println("일  월  화  수  목  금  토");
                //메서드 받아와서 출력시키기 ...
                getCalendar(year, month);

            }catch (Exception e){ //숫자 형식 오류가 발생한 경우
                System.out.println("입력 형식이 잘못되었습니다. 입력예시) 2024 5");
            }
        }
    }

    // 해당 달에 시작하는 1일이 몇요일인지 알아야한다
    // 해당 달에 끝나는 날짜를 알아야한다 28일, 29일, 30일, 31일
    public static void getCalendar(int year, int month){

        //년 월을 알고있으면 시작일자를 1로 고정
        LocalDate startDate = LocalDate.of(year, month,1);

        int yoil = startDate.getDayOfWeek().getValue(); //요일의 값 가져오기 1(월) ~ 7(일)
        yoil = yoil == 7 ? 0 :yoil;

        //5월 1일에서 다음달로 넘어가고(6월1일) -1 하면 마지막 날짜나옴
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
       // System.out.println(endDate); //2024-05-31
        int lastDay = endDate.getDayOfMonth();

        for(int i=1; i <= yoil; i++){
            System.out.print("   ");
        }
        for(int i = 1, n = yoil + 1; i <= lastDay; i++, n++){
            System.out.print((i<10)? "  "+ i:" "+i);
            if(n%7==0) System.out.println(); //토요일 지나면 줄개행
        }
        System.out.println();
    }

}
