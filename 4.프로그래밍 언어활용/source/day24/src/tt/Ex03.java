package tt;

import java.util.ArrayList;
import java.util.Collections;

public class Ex03 {
    public static void main(String[] args) {
        int[] array = {18,99,33};
        int n = 13;
        ArrayList<Integer> number = new ArrayList<>();

        for(int i=0; i<array.length; i++){
            if(array[i]> n){
                number.add(array[i] - n);
            }else{
                number.add(n - array[i]);
            }
        }
        int minIndex = number.indexOf(Collections.min(number));
        System.out.println(array[minIndex]);
    }
}
