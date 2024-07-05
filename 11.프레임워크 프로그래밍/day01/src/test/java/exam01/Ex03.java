package exam01;

import exam01.config.AppCtx2;
import exam01.member.controllers.RequestJoin;
import exam01.member.services.InfoService;
import exam01.member.services.JoinService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {

    @Test
    void test1(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        JoinService joinService = ctx.getBean(JoinService.class);
//        MemberDao memberDao = ctx.getBean(MemberDao.class);
        InfoService infoService = ctx.getBean(InfoService.class);

        RequestJoin form = RequestJoin.builder()
                .email("user01@test.org")
                .userName("사용자01")
                .password("12345678")
                .confirmPassword("12345678")
                .build();

        joinService.process(form);

//        memberDao.getList().forEach(System.out::println);

        infoService.printList();

        ctx.close();
    }
}
