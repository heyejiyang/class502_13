package test;

public class ComposeCoffee implements Cafe{
    private String name = "컴포즈커피";

    @Override
    public void order(Person person) {
        String menu = person.getMenu();
        int price = getPrice(menu);

        if (price != -1) {
            System.out.printf("%s은(는) %s에서 %s를 주문했습니다. 가격은 %d원입니다.%n", person.getName(), name, menu, price);
        } else {
            System.out.println("존재하지 않는 음료입니다.");
        }
    }

    private int getPrice(String menu) {
        switch (menu) {
            case "아메리카노":
                return 1500;
            case "라테":
                return 2600;
            default:
                return -1;
        }
    }
}
