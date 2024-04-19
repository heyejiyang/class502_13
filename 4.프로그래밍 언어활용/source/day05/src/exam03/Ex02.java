package exam03;

public class Ex02 {
    public static void main(String[] args) {
        Human human = new Human();
        human.move();
        Human human2 = new Human();
        human2.move();
        System.out.println(human2 == human);
    }
}
