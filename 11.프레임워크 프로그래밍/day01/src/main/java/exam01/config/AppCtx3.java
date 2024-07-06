package exam01.config;


import exam01.member.dao.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "exam01.member") //member패키지를 포함한 하위 패키지들이 scan범위에 해당한다.
@ComponentScan("exam01.member")//스캔 범위 설정, 스캔 할 패키지 범위를 알려줌으로써 클래스를 스캔함, 특정 애노테이션이 있는 곳을 찾아서 컨테이너 안에 생성해줌
public class AppCtx3 {

//    @Bean
//    public MemberDao memberDao(){
//        System.out.println("수동등록 bean");
//        return new MemberDao();
//    }

}
