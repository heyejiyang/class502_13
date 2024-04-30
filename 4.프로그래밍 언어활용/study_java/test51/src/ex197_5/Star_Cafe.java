package ex197_5;

public class Star_Cafe {
    String star = "별다방";
    String menu;
    int money;


    public void menuMethod(String menu){
        this.menu = menu;
        if(menu.equals("아메리카노")){
            this.money = 4000;
        }
    }
    public void showInfo(){
        System.out.println(menu+"의 가격은 "+money+"입니다.");
    }
}
