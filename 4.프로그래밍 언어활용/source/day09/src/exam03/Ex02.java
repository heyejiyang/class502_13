package exam03;

public class Ex02 {
    public static void main(String[] args) {
        String fileName = "image.png";
        String extension = fileName.substring(6);//p부터끝까지
        System.out.println(extension);
        String extension2 = fileName.substring(2,5); //2,3,4위치
        System.out.println(extension2);
    }
}
