package tt;

public class Ex02 {
    public static void main(String[] args) {
        String my_string = "AbCdEfG";
        String answer ="";
        for(char c  : my_string.toCharArray()){
            if(Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
                answer = answer.concat(String.valueOf(c));
            }
            else if(Character.isLowerCase(c)){
                c = Character.toUpperCase(c);
                answer = answer.concat(String.valueOf(c));
            }
        }
        System.out.println(answer);
    }
}
