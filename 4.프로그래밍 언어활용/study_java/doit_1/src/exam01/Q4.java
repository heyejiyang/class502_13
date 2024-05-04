package exam01;

public class Q4 {
    public static void main(String[] args) {
        int n = 1;
        for(int i=0; i<4;i++){
            for(int k = 0; k<3-i; k++){
                System.out.print(" ");
            }
            for(int j = n; j>0;j--){
                System.out.print("*");
            }
            n+=2;
            System.out.println();
        }

    }
}
