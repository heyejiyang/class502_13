package exam04;

public class Box { //박스안에 과일 두개 담자!
    //과거에 다형성이용
    private Object item; //모든 클래스의 공통적인 상위 클래스
    public Object getItem(){
        return item;
    }
    public void setItem(Object item){
        this.item = item;
    }

}
