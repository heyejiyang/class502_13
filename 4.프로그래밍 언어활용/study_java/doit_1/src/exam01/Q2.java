package exam01;

public class Q2 {
    String orderNum;
    String id;
    String day;
    String name;
    String productsNum;
    String address;

    @Override
    public String toString() {
        return  "주문 번호 :" + orderNum + '\n' +
                "주문자 아이디: " + id + '\n' +
                "주문 날짜: " + day + '\n' +
                "주문자 이름: " + name + '\n' +
                "주문 상품 번호: " + productsNum + '\n' +
                "배송 주소: " + address + '\n';
    }
}
