package exam01;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        for(int i=0; i< names.size(); i++){
            String name = names.get(i);
            System.out.println(name);
        }
        //제거 뒤에서부터
        for(int i = names.size()-1; i>=0; i--){
            names.remove(i);
        }
    }
}
