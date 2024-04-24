package exam04;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] lotto = new int[6];
        int count = 0;

        while (count < 6) {
            int num = getNumber();
            if (chkDuplicated(lotto, num)) {
                continue;
            }
            lotto[count] = num;
            count++;
        }
        System.out.println(Arrays.toString(lotto));
    }

    public static int getNumber() {
        return (int) (Math.random() * 43) + 1;
    }

    public static boolean chkDuplicated(int[] lotto, int num) {
        for (int n : lotto) {
            if (n == num) return true;
        }
        return false;
    }
}
