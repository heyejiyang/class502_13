package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Transportation trans = Transportation.BUS;
        Enum<Transportation> trans2 = trans; //가능
        System.out.println(trans instanceof Transportation);//true
        switch(trans){
            case BUS: //자료형명시x Transportation.BUS 이렇게 안해도 알아서 판단
                System.out.println("버스");
                break;
            case SUBWAY:
                System.out.println("지하철");
                break;
            case TAXI:
                System.out.println("택시");
                break;
        }
    }

}
