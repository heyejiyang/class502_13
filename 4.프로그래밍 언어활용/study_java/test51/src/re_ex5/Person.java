package re_ex5;

public class Person {

    private String name;
    private int money;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void decreaseMoney(int amount) {
        money -= amount;
    }
}
