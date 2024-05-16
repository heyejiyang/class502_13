package exam01;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        String[] unfinished = solution(todo_list, finished);
        System.out.println(Arrays.toString(unfinished));
    }

    public static String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer = null;
        int cnt = 0;
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) cnt++;
        }

        answer = new String[cnt];

        int no = 0;
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) {
                String work = todo_list[i];
                answer[no] = work;
                no++;
            }
        }

        return answer;
    }
}