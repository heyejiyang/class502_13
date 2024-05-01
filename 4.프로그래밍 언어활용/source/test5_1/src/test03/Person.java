package test03;

public class Person {

    private String name;
    private String menu;

    public Person(String name, String menu){
        this.name = name;
        this.menu = menu;
    }

    public void visitCafe(ChoiceMenu choice){
        choice.order(this);
    }

    public String getName() {
        return name;
    }

    public String getMenu() {
        return menu;
    }
}
