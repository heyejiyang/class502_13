package exam02;

public abstract class Car {
    public abstract void start();
    public abstract void press();
    public abstract void turnoff();

    public final void run(){
        start();
        press();
        turnoff();
    } //템플릿 메서드

}
