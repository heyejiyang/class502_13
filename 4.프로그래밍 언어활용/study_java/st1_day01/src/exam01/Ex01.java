package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //학번 50명에게 부여
        int[] student = new int[50];
        int Id = 18018049;

        for(int i=0;i<student.length;i++){
            student[i] = Id;
            Id++;
            System.out.println(student[i]);
        }

    }
}
