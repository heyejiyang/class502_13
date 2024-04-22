package exam02;

public class SportCar extends Car{
    //Car클래스에 final붙어있음 -> 상속x


    @Override
    public void start() {
        System.out.println("시동걸기");
    }

    @Override
    public void press() {
        System.out.println("엑셀");
    }

    @Override
    public void turnoff() {
        System.out.println("시동끄기");
    }

//    @Override
//    public void run() {
//        turnoff();
//        start();
//        press();
//    }
}
