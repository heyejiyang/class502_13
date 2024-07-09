package config;

//스프링 테스트 모듈을 사용해서 의존성 주입

import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class) //설정 클래스가 뭔지 체크하고 의존성을 주입할 수 있게 컨테이너가 생성된다.
public class DBConnectionTest {

    //datasource 주입
    @Autowired
    private DataSource dataSource;

    @Test
    void test1() throws Exception {
        //연결객체
        Connection con = dataSource.getConnection();
        System.out.println(con);
    }


}
