package exam01;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};
        String[] answer = {};
        int[] j = new int[finished.length-1];
        int n = 0;

        for(int i = 0; i< finished.length; i++){
            if(!finished[i]){
                j[n] = i;
                n++;
            }
        }

        for(int i = 0; i< j.length; i++){
            System.out.println(j[i]);
        }

//        for(int k = 0; k< todo_list.length; k++){
//            int num = 0;
//            for(int i = 0; i< j.length; i++){
//                num = j[i];
//                System.out.println(todo_list[num]);
//            }
//
//        }
    }
}
