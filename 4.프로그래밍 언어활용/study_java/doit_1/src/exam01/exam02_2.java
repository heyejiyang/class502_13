package exam01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exam02_2 {
    public static void main(String[] args) {
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        String[] unfinished = solution(todo_list, finished);
        System.out.println(Arrays.toString(unfinished));
    }

    public static String[] solution(String[] todo_list, boolean[] finished) {
        List<String> unfinished = new ArrayList<>();
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) {
                unfinished.add(todo_list[i]);
            }
        }

        return unfinished.toArray(String[]::new);
        //String[] data = new String[unfinished.size()];
        //return unfinished.toArray(data);

    }
}
