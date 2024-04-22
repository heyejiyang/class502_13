package exam04;

public class Order implements Seller,Buyer {
    @Override
    public void buy() {
        System.out.println("폭풍쇼핑");
    }

    @Override
    public void sell() {
        System.out.println("판매왕");
    }
    public void method(){
        Buyer.super.method();
    }

}
