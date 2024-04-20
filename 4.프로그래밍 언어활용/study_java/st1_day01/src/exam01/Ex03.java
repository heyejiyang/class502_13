package exam01;

public class Ex03 {
    public static void main(String[] args) {
        //배열도 선언과 동시에 초기화를 해보자
        //int[] nums = new int[]{1,2,3,4,5};//5개 공간 생성
        int[] nums = {10,20}; //생략도 가능
        /*
        * int[] nums;
        * nums = {1,2,3,4}; new 연산자 없이 분리는 불가능
        * */

        for(int i = 0; i<nums.length; i++){
            System.out.println(nums[i]);
        }


    }
}
