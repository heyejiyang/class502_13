package exam02;

import java.time.LocalDate;
import java.util.*;

public class CalendarTest {
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

                Map<String, Object> calendarData = getCalendar(year, month);

                List<String> days = (List<String>) calendarData.get("days"); //1
                List<String> lastDay = (List<String>) calendarData.get("lastDay");
                List<String> yoils = (List<String>) calendarData.get("yoils");

//                for (int i = 0; i < days.size(); i++) {
//                    System.out.println("Day: " + days.get(i) + ", Date: " + dates.get(i) + ", Yoil: " + yoils.get(i));
//                }
//                for (int i = 0; i < days.size(); i++) {
//                    System.out.println("Day: " + days.get(i) + ", Date: " + lastDay.get(i) + ", Yoil: " + yoils.get(i));
//                }

                int k = 1;
                for (int i = 0; i < days.size(); i++) {
                    System.out.print(days.get(i)+"  ");
                    if(k == 7){
                        k = 0;
                        System.out.println();
                    }
                    k++;
                }

            }catch (Exception e){ //숫자 형식 오류가 발생한 경우
                System.out.println("입력 형식이 잘못되었습니다. 입력예시) 2024 5");
            }
        }
    }

    // 해당 달에 시작하는 1일이 몇요일인지 알아야한다
    // 해당 달에 끝나는 날짜를 알아야한다 28일, 29일, 30일, 31일
    public static Map<String, Object> getCalendar(int year, int month){
        /*
        * 1. 매월의 1일이 어떤 요일에 시작하는지 !!!! 그만큼 들여쓰기해서 띄어쓰기 해줘야한다
        * 매월의 1일은 어떤요일인지 어떻게 알까 ......->
        * 2. 매월의 종료일이 며칠인지(30,31,28,29)
        * */

        //년 월을 알고있으면 시작일자를 1로 고정
        LocalDate startDate = LocalDate.of(year, month,1);

        int syoil = startDate.getDayOfWeek().getValue(); //요일의 값 가져오기 1(월) ~ 7(일)
        // 이거만큼 띄어주면 된다.
        //System.out.println(yoil); // 3 // 5월1일은 수요일에 시작 -> 3만큼 띄어쓰기
        //요일을 0(일) ~ 6(토) -> yoil % 7
        syoil = syoil == 7 ? 0 : syoil;

        //5월 1일에서 다음달로 넘어가고(6월1일) -1 하면 마지막 날짜나옴
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        //System.out.println(endDate); //2024-05-31


        int start = syoil * -1;

        int cellNum = syoil + endDate.getDayOfMonth() > 35 ? 42 : 35; //전체 35칸
        int day = endDate.getDayOfMonth();
        //System.out.println(day); //31

        Map<String, Object> data = new HashMap<>();
        List<String> days = new ArrayList<>(); // 날짜, 1, 2, 3,
        List<String> lastDay = new ArrayList<>();
        List<String> yoils = new ArrayList<>(); // 요일 정보
        for (int i = start; i < cellNum + start; i++) {
            LocalDate date = startDate.plusDays(i);

            int yoil = date.getDayOfWeek().getValue();
            yoil = yoil == 7 ? 0 : yoil; // 0 ~ 6 (일 ~ 토)
            days.add(String.valueOf(date.getDayOfMonth()));
            lastDay.add(String.valueOf(day));
            yoils.add(String.valueOf(yoil));

            data.put("days", days); //1
            data.put("lastDay", lastDay); // 31
            data.put("yoils", yoils); //3
        }

        return data;
    }


}
