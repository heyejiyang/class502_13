package exam01;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //터미널에서 입력

//        System.out.print("숫자를 입력하세요: ");
//        int num= scan.nextInt();
//        System.out.println("입력한 숫자는 "+num+"입니다.");

        System.out.print("이름을 입력하세요: ");
        String name = scan.nextLine();
        System.out.println("이름은"+name+"입니다.");
    }
}
