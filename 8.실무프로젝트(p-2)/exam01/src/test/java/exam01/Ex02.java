package exam01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.management.remote.JMXServerErrorException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ex02 {

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "STUDY";
    private String password = "oracle";

    @BeforeAll //모든 테스트 메서드 호출 전에 단 한번실행 - 공통 초기화
    static void init(){ //공통 초기화 한번 실행
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    @Test
    void test1(){

        String keyword = "사용자";
        String sql = "SELECT * FROM MEMBER WHERE USER_NM LIKE ?"; //변수가 교체 될 부분은 ?로 작성
        // 내부적으로 보안적으로 취약한 부분은 제외하고 값을 넣어줌

        //조회
        try(Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            //물음표의 위치는 1개밖에 없다 현재는 하나밖에없으니...
            pstmt.setString(1,"%"+keyword+"%");

            // 한칸씩 커서이동하면서 데이터 조회
            ResultSet rs = pstmt.executeQuery();

            List<Member> members = new ArrayList<>(); //db조회 후 멤버 객체 list에 담기

            while (rs.next()){
                long userNo = rs.getLong("USER_NO");
                String userId = rs.getString("USER_ID");
                String userPw = rs.getString("USER_PW");
                String userNm = rs.getString("USER_NM");
                String mobile = rs.getString("MOBILE");

                LocalDateTime regDt = rs.getTimestamp("REG_DT").toLocalDateTime();

                Member member = new Member();
//                member.setUserNo(userNo); //객체 형태로 변환작업 수행
//                member.setUserId(userId);
//                member.setUserPw(userPw);
//                member.setUserNm((userNm));
//                member.setMobile(mobile);
//                member.setRegDt(regDt);

                members.add(member);

                System.out.printf("USER_NO: %d, USER_ID: %s, USER_PW: %s, USER_NM: %s, MOBILE: %s%n, REG_DT: %s%n", userNo, userId, userPw, userNm, mobile, regDt);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Test
    void test2(){
        String userId = "USER04";
        String userPw = "123456";
        String userNm = "사용자04";
        String mobile = "01012121200";
        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, MOBILE) VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?)";
        //?의 순서대로 넣어야한다. 1 2 3 4

        try(Connection conn = DriverManager.getConnection(url,user,password);
        PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"USER_NO"})){//두번째 매개변수로 기본키로 추출할 값을 정할 수 있다.

            pstmt.setString(1,userId);
            pstmt.setString(2,userPw);
            pstmt.setString(3,userNm);
            pstmt.setString(4,mobile);

            int cnt = pstmt.executeUpdate();
            System.out.println(cnt);

            ResultSet rs = pstmt.getGeneratedKeys();
            // PreparedStatement 두번째 매개변수 값 가져오게 됨
            // 기본키로 추가한 userNo 알수있게 됨
            if(rs.next()){ //커서 한번 이동
                long userNo = rs.getLong(1);
                System.out.printf("USER_NO: %d%n" ,userNo);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
