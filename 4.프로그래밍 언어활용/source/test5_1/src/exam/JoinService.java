package exam;

public class JoinService {
    private static JoinService j1;

    private JoinService(){}
    public static JoinService getInstance(){
        if(j1 == null) {
            j1 = new JoinService();
        }
        return j1;
    }
}
