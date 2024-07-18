package exam01;

import config.AppCtx;
import member.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex01 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test() {
        String sql = "INSERT INTO MEMBER (SEQ, EMAIL, PASSWORD, USER_NAME) VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)";

        int result = jdbcTemplate.update(sql, "user03@test.org", "123456","사용자03");

        System.out.println(result);
    }
/*
    @Test
    void test2(){
        List<Member> members = jdbcTemplate.query("select * from MEMBER", new RowMapper<Member>() {//slq문으로 조회된 결과를 넘겨주면 Member쪽으로 값을 바꿔준다.
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Member.builder()
                        .seq(rs.getInt("SEQ"))
                        .email(rs.getString("EMAIL"))
                        .password(rs.getString("PASSWORD"))
                        .userName(rs.getString("USER_NAME"))
                        .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                        .build();
            }
        });
        members.forEach(System.out::println);
    }
    */
    /*@Test
    void test2(){
        List<Member> members = jdbcTemplate.query("select * from MEMBER", (rs, num) -> Member.builder()
                .seq(rs.getInt("SEQ"))
                .email(rs.getString("EMAIL"))
                .password(rs.getString("PASSWORD"))
                .userName(rs.getString("USER_NAME"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build());

        members.forEach(System.out::println);
    }*/
    @Test
    void test2(){
//        List<Member> members = jdbcTemplate.query("select * from MEMBER", (rs, num) -> mapper(rs, num));
        List<Member> members = jdbcTemplate.query("select * from MEMBER", this::mapper); //메서드 참조

        members.forEach(System.out::println);
    }

    @Test
    void test3(){
        String email = "user08@test.org";
        try{
            Member member = jdbcTemplate.queryForObject("SELECT * FROM MEMBER WHERE EMAIL = ?", this::mapper, email);

            System.out.println(member);
        }catch (Exception e){
            System.out.println("없음");
        }
    }

    @Test
    void test4(){
        int total = jdbcTemplate.queryForObject("select count(*) from MEMBER", int.class);
        System.out.println(total);
    }


    private Member mapper(ResultSet rs, int num) throws SQLException{
        return Member.builder()
                .seq(rs.getInt("SEQ"))
                .email(rs.getString("EMAIL"))
                .password(rs.getString("PASSWORD"))
                .userName(rs.getString("USER_NAME"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();
    }

}
