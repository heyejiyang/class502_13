package Exam;

public class Ex01 {
    public static void main(String[] args) {
        Starbucks starBucks = new Starbucks();
        Coffeebean coffeeBean = new Coffeebean();

        Person kim = new Person("김씨", 10000);
        Person lee = new Person("이씨", 15000);

        kim.setMenu("아메리카노");
        lee.setMenu("라떼");

        try {
            starBucks.enter(kim).order().exit();
            coffeeBean.enter(lee).order().exit();

            System.out.println(kim);
            System.out.println(lee);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("커피숍별 매출액 요약");
        CoffeeShop.showSaleSummary(starBucks);
        CoffeeShop.showSaleSummary(coffeeBean);
    }
}
