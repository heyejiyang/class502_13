public class ComposeCoffee {
    private String name = "컴포즈커피";
    private int price;
    String menu;

    public void menuMethod(String menu){
        if(menu.equals("아메리카노")){
            price = 1500;
            this.menu = "아메리카노";
        }else if(menu.equals("라테")){
            price = 2600;
            this.menu = "라테";
        }
    }

    void showInfo(){
        System.out.printf("%s의 %s는 %d원 입니다.",this.name, this.menu,this.price);
    }
}
