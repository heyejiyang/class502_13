package exam01;

import java.util.Scanner;

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

                System.out.printf("---- %d년 %d월 ----%n",year,month); //달력 출력

                //요일 출력 칸
                System.out.println("일  월  화  수  목  금  토");
                //메서드 받아와서 출력시키기 ...

            }catch (Exception e){ //숫자 형식 오류가 발생한 경우
                System.out.println("입력 형식이 잘못되었습니다. 입력예시) 2024 5");
            }
        }
    }

    // 해당 달에 시작하는 1일이 몇요일인지 알아야한다
    // 해당 달에 끝나는 날짜를 알아야한다 28일, 29일, 30일, 31일
    public static Object getCalendar(int year, int month){
        /*
        * 1. 매월의 1일이 어떤 요일에 시작하는지 !!!! 그만큼 들여쓰기해서 띄어쓰기 해줘야한다
        * 매월의 1일은 어떤요일인지 어떻게 알까 ......->
        * 2. 매월의 종료일이 며칠인지(30,31,28,29)
        * */

        return null;
    }


}
