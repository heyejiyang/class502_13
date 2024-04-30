public class MegaCoffee {
    private String name = "메가커피";
    private int price;
    String menu;


    public void menuMethod(String menu) {
        if (menu.equals("아메리카노")) {
            price = 2000;
            this.menu = "아메리카노";
            System.out.printf("%s의 %s는 %d원 입니다.%n", this.name, this.menu, this.price);
        } else if (menu.equals("라테")) {
            price = 2800;
            this.menu = "라테";
            System.out.printf("%s의 %s는 %d원 입니다.%n", this.name, this.menu, this.price);
        }
    }
}