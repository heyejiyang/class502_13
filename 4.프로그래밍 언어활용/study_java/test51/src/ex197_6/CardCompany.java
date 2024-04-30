package ex197_6;

public class CardCompany {
    private static int serialNum = 10;
    String name;
    private int cardNum;

    public CardCompany(String name){
        this.name = name;
        cardNum = ++serialNum;
    }

    public void showInfo(){
        System.out.println(name+"님의 카드번호는 "+cardNum+"입니다.");
    }
}
