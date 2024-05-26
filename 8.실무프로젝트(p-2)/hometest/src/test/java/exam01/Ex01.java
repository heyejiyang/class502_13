package exam01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDateTime;

public class Ex01 {
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
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@localhost:1521:XE";//같은 위치에 있으면 localhost
        //현재 같은 서버에 존재하니까 localhost, 기본포트 1521, 연습용 계정 사용시 EE
        //다른 서버에 있으면 ip주소나 도메인 주소 입력 ex)3.100.2.111

        String user = "STUDY";
        //연습용 계정은 SCOTT
        String password = "oracle"; // SCOTT은 tiger

//        try{
//            Connection conn = DriverManager.getConnection(url, user, password);
//            //db에 연결할 수 있는 핵심적인 메서드이다.
//            System.out.println(conn);//접속확인
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement()){//Statement 객체로 sql문 실행 할수있다.

            String sql = "INSERT INTO BOARD (SEQ, POSTER, SUBJECT, CONTENT) VALUES (SEQ_MEMBER.NEXTVAL, 'USER04', '게시글제목4', '게시글 내용4')";

            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt);

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
