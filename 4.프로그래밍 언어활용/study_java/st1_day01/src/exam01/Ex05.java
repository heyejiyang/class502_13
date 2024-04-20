package exam01;
import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums1 = new int[4]; //기본값이 들어감 ' 0 '
        System.out.println(Arrays.toString(nums1));

        double[] nums2 = new double[4];// 기본값 ' 0.0 '
        System.out.println(Arrays.toString(nums2));

        boolean[] bools = new boolean[4];// 기본값 ' false '
        System.out.println(Arrays.toString(bools));
    }
    //배열을 출력할때 기본적인 동작은 주소를 출력한다 nums1;
    //Arrays는 주소의 내용을 문자열로 바꿔서 보여준다.
}
/*
* jdk: java development kit
* - 개발할때 필요한 다양한 기능들이 담겨있다.
* - java.util 패키지: 자바 편의 기능이 여기에 많이 담겨있다.
*       뒤에 s가 붙어있으면 무언가의 편의 기능을 나타내는것
*       Arrays: 배열의 편의 기능
*       Collections: 컬렉션의 편의 기능
*
*       java.util.stream -> Collectors
*
* 다른 패키지 내용 공유 받을때 import java.util.Arrays 이런식으로 불러온다.
 * */