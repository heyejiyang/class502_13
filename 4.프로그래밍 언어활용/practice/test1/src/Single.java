public class Single {

    private static Single s1;

    public static Single singlemethod(){
        if(s1 == null){
            s1 = new Single();
        }

        return s1;
    }


}
