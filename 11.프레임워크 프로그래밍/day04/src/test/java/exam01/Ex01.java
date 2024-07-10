package exam01;

import config.AppCtx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;

@Transactional //테스트할땐 자동으로 롤백해줌
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class Ex01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test1() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = jdbcTemplate.update(con -> {
            String sql = "INSERT INTO MEMBER (SEQ, EMAIL, PASSWORD, USER_NAME)" + " VALUES (SEQ_MEMBER.NEXTVAL,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"SEQ"});
            //Column name
            pstmt.setString(1, "user06@test.org");
            pstmt.setString(2, "12345678");
            pstmt.setString(3, "사용자06");
            return pstmt;
        },keyHolder); //세번째 매개변수 key holeder에 발생한 자동 증감번호를 넣어준다
        System.out.println(result);
       Number key =  keyHolder.getKey();//증감번호 가져오기 , 반환값이 Number인 이유? -> Number에는 변환 메서드가 있다 int, long 어떤걸 쓸지는 개발자만 아니까.. 숫자 관련 상위 추상 클래스

        long seq = key.longValue(); //자동 증감된 키값을 가져올 수 있게되었다.
        System.out.println(seq);
    }
}
