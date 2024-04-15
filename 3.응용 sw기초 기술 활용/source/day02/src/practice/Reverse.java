package practice;

public class Reverse {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] reverse = new int[nums.length];

       for(int i = nums.length-1,j = 0; i >=0 ; i--){
           reverse[j] = nums[i];
           j++;
       }
       for(int i = 0; i<reverse.length;i++){
           System.out.print(reverse[i]);
       }


    }
}
