public class Person {
    private String name;
    private String menu;


    public Person(String name, String menu){
        this.name = name;
        this.menu = menu;
    }

    public void Mega_Cafe(MegaCoffee mega){
        mega.menuMethod(this.menu);
    }
    public void Compose_Cafe(ComposeCoffee com){
        com.menuMethod(this.menu);
    }
}
