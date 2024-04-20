package exam01;

public class Ex07 {
    public static void main(String[] args) {
        //다차원배열
        int[][] nums = new int[2][3];//2행 3열
        nums[0][0] = 10;
        nums[0][1] = 20;
        nums[0][2] = 30;

        int a = 5;
        for(int i = 0; i< nums.length;i++){
            for(int j = 0; j< nums[i].length;j++) {
                nums[i][j] = a;
                System.out.print(nums[i][j]+" ");
                a++;
            }
            System.out.println();
        }

    }
}
