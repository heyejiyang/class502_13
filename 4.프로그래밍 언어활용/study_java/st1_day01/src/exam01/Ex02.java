package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = new int[4];
                /*
                * new연산자: 메모리에 공간을 생성해주는 역할
                * 4개의 int 자료형 변수 생성
                * int형 변수가 네개의 붙어있는 공간에 각각 생성되는것(물리적인 나열구조)
                * int는 공간의 크기가 4byte (전부 동일한 자료형!!!)
                *
                * 배열 -> 순서!!!!에대한 위치를 쉽게 알 수 있다. -[]인덱스 연산자
                * index는 0부터 시작
                *
                * 순서에 대한 반복을 쉽게할 수 있는 -> for문 사용
                *
                * */
        nums[0] = 10; //첫번째 인덱스
        nums[1] = 20;
        nums[2] = 30;
        nums[3] = 40;

        System.out.println(nums[0]);//변수명 그 자체로 보고 쓰인다.
        System.out.println(nums[1]);
        System.out.println(nums[3]);

        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

        /*
        * 변수: 연산을 하기위해 값을 담기위한 목적
        * 선언과 동시에 초기화
        * 자료형[] 배열명 = new 자료형 []{값,값2,값3};
        * */
    }
}
