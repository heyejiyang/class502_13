package config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan(basePackages = "member",
//excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {ManualBean.class})})
//ManualBean이 포함 되어있는 대상은 자동 스캔 범위에서 제외된다.
//한개 일 경우 중괄호 생략 가능

//@ComponentScan(basePackages = "member",
//excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//classes = {MemberDao.class, JoinValidator.class})
//)

//@ComponentScan(basePackages = "member",
//excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX,
//pattern = "member\\\\..*Dao")})

@ComponentScan(basePackages = "member",
excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "member..*Dao")
)
public class AppCtx {

}
