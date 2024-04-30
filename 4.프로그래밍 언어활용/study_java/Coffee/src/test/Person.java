package test;

public class Person {
    private String name;
    private String menu;//사람이 고른 메뉴

    public Person(String name, String menu) {
        this.name = name;
        this.menu = menu;
    }

    public void visitCafe(Cafe cafe) { //어디 카페 갈건지
        cafe.order(this);
    }

    public String getName() {//고른사람 이름도 넘겨주기
        return name;
    }

    public String getMenu() { //고른 메뉴 넘겨줄거임
        return menu;
    }
}
