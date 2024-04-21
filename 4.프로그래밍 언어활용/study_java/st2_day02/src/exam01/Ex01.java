package exam01;

public class Ex01 {
    public static void main(String[] args) {
        LoginService service = new LoginService();
        //service.login("user01","3452");

        //try {
            service.login("user01","3452");
        //} catch (UserIdException | UserPwException e){
        //    System.out.println(e.getMessage());
        //}
    }
}
