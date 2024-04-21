package exam01;

public class LoginService {
    public void login(String userId, String userPw) //throws UserIdException,UserPwException{
    {
        /*
        * userid - user01
        * usrepw - 1234
        * */

       // try {
            if (!userId.equals("user01")) {
                throw new UserIdException("가입되지 않은 회원입니다.");
            }
            if (!userPw.equals("1234")) {
                throw new UserPwException("비밀번호가 일치하지 않습니다.");
            }
            //아이디와 비번이 전부 일치하는 경우
            System.out.println("로그인 완료!");
      //  }
//        } catch (UserIdException e){
//            System.out.println(e.getMessage());
//        }catch (UserPwException e){
//            System.out.println(e.getMessage());
//        }
//        catch (UserPwException | UserIdException e){
//            System.out.println(e.getMessage());
//        }
    }
}
