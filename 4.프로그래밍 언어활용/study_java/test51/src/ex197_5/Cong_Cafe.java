package ex197_5;

public class Cong_Cafe {

    String cong="콩다방";
    String menu;
    int money;


    public void menuMethod(String menu){
        this.menu = menu;
        if(menu.equals("라테")){
            this.money = 4500;
        }
    }
    public void showInfo(){
        System.out.println(menu+"의 가격은 "+money+"입니다.");
    }

}
