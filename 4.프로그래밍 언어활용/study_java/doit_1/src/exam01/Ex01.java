package exam01;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 오늘 해야 할 일이 담긴 문자열 배열 todo_list와 각각의 일을 지금 마쳤는지를 나타내는 boolean 배열 finished가 매개변수로 주어질 때,
* todo_list에서 아직 마치지 못한 일들을 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
 *
* */
public class Ex01 {
    public static void main(String[] args) {
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};

        /*for(int i = 0; i< finished.length; i++){
                if(!finished[i]){
                    System.out.print(todo_list[i]+" ");
                }

        }

        *
        * */

         // true에 해당하는 항목들을 담을 ArrayList 생성
        ArrayList<String> unfinishedTasks = new ArrayList<>();

        // finished 배열을 순회하며 true에 해당하는 항목들을 ArrayList에 추가
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) {
                unfinishedTasks.add(todo_list[i]);
            }
        }

        // ArrayList를 배열로 변환
        String[] answer = unfinishedTasks.toArray(new String[0]);
        //new String[0]은 크기가 0인 String 배열을 생성
        // 0으로 생성해도 상관 없는 이유 -> ArrayList가 요소들을 배열로 복사할 때 필요한 크기를 정확히 조절할 수 있기 때문
        //실제로는 아무런 요소도 담지 않고, 메모리에는 매우 작은 공간만 차지


        /*
        * new String[0]는 크기가 0인 새로운 String 배열을 생성합니다.
이 배열은 ArrayList에 저장된 요소들을 담기에 충분한 크기를 갖고 있지 않습니다.
그러나 ArrayList는 필요에 따라 내부적으로 새로운 배열을 생성하여 요소들을 복사합니다. 그리고 이 새로운 배열의 레퍼런스가 toArray() 메서드에 의해 반환됩니다.
이 배열은 String[] answer에 할당되어 메서드의 반환값으로 사용됩니다.
        * */

        // 결과 출력
        System.out.println(Arrays.toString(answer));

    }
}


// 결과: ["practiceguitar", "studygraph"]