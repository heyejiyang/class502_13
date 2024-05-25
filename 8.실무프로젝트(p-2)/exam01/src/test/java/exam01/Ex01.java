package exam01;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.time.LocalDateTime;

public class Ex01 {
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

            String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, MOBILE) VALUES (SEQ_MEMBER.NEXTVAL, 'USER01', '123456', '사용자01', '01000000000')";

            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt);

        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    @Test
    void test2(){
        try {
            // 오라클 드라이버 동적 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "STUDY";
        String password = "oracle";

        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement()) {
            String keyword = "사용자";
            //키워드가 포함되었는지 안되었는지로 판단
            String sql = "SELECT * FROM MEMBER WHERE USER_NM LIKE '%"+keyword+"%'";
            //String sql = "SELECT * FROM MEMBER";
            ResultSet rs = stmt.executeQuery(sql);
            //조회 결과 여기서 한행씩 찾아서 가져옴
            while (rs.next()){
                long userNo = rs.getLong("USER_NO"); //컬럼명 직접 명시해야 순서가 바뀌어도 문제가 없게 된다.
                String userId = rs.getString("USER_ID");
                String userPw = rs.getString("USER_PW");
                String userNm = rs.getString("USER_NM");
                String mobile = rs.getString("MOBILE");
                //날짜와 시간 가져오기
                LocalDateTime regDt = rs.getTimestamp("REG_DT").toLocalDateTime();
                System.out.printf("USER_NO: %d, USER_ID: %s, USER_PW: %s, USER_NM: %s, MOBILE: %s%n, REG_DT: %s%n", userNo, userId, userPw, userNm, mobile, regDt);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
