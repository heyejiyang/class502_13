public class Person {
    private String name;
    private String menu;
    public Person(String name, String menu){
        this.name = name;
        this.menu = menu;
    }
    public void visitCafe(){
        System.out.println(name+"이 "+menu+"를 마셨습니다.");
    }

    public void mega_Cafe(MegaCoffee mega){
        mega.menuMethod(this.menu);
        System.out.println(name+"이 "+menu+"를 마셨습니다.");
    }
    public void compose_Cafe(ComposeCoffee com){
        com.menuMethod(this.menu);
        System.out.println(name+"이 "+menu+"를 마셨습니다.");
    }
}
