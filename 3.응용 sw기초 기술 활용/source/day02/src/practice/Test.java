package practice;

public class Test {
    public static void main(String[] args) {
       int[] nums  = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum=0;
       for(int i : nums){
           sum += i;
       }
        System.out.println(sum/(double)nums.length);
    }
}
