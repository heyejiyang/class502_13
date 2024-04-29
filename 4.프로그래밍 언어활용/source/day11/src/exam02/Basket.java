package exam02;

import java.util.ArrayList;
import java.util.List;

public class Basket<T> {
    private List<T> items = new ArrayList<>();

    public void add(T item){ //추가
        items.add(item);
    } //추가

    public List<T> getItems(){ //꺼냄
        return items;
    } //조회
}
