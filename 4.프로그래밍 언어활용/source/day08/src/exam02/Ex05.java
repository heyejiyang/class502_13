package exam02;

public class Ex05 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100);
        //sb.append("ABC").append("DEF").append("GHI");

//        StringBuffer sb2 = sb.append("ABC");
//        System.out.println(sb==sb2); //동일한 객체를 반환 true
//        StringBuffer sb3 = sb2.append("DEF");
//        System.out.println(sb == sb3);

        String str = sb.append("ABC").append("DEF").append("GHI").toString();
        System.out.println(str);
    }
}
