package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Order od = new Order();
        od.buy();
        od.sell();
        Buyer buyer = od;
        buyer.buy();

        Seller seller = od;
        seller.sell();
    }
}
