package re_ex5;

public class Cafe {
    private String name;
    private String menu;
    private int price;

    private static final int AMERICANO_PRICE = 4000;
    private static final int LATTE_PRICE = 4500;
    public Cafe(String name, String menu) {
        this.name = name;
        this.menu = menu;
        if (menu.equals("아메리카노")) {
            this.price = AMERICANO_PRICE;
        } else if (menu.equals("라테")) {
            this.price = LATTE_PRICE;
        } else {
            this.price = 0;
        }
    }

    public void order(Person person) {
        if(price == 0){
            System.out.println("해당 음료는 판매하지 않습니다.");
            return;
        }
        if (person.getMoney() < price) {
            System.out.println("잔액이 부족합니다.");
        } else {
            person.decreaseMoney(price);
            System.out.println(person.getName() + "는 " + name + "에서 " + price + "원짜리 " + menu + "를 마셨습니다.");
        }
    }

}
