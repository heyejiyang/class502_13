package org.choongang.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement //트랜잭션 관련 설정 자동화
@MapperScan("org.choongang") //마이바티스 매퍼 인터페이스를 스캔하여 빈으로 등록
@EnableJdbcRepositories("org.choongang")//JDBC설정 활성화
public class DBConfig extends AbstractJdbcConfiguration {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() { //데이터베이스 연결을 위한 빈 설정

        DataSource ds = new DataSource();

        /*연결 설정 S*/
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        ds.setUsername(System.getenv("db.username"));
        ds.setPassword(System.getenv("db.password"));
        /*연결 설정 E*/

        /*커넥션 풀 설정 S*/
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true); //연결이 유효한지 체크하겠다
        ds.setMinEvictableIdleTimeMillis(1000 * 60); //유휴객체 살아있는시간 - 기본은 1분(기본값)
        ds.setTimeBetweenEvictionRunsMillis(1000 * 5);//체크 주기 5초에 한번씩(기본값)
        /*커넥션 풀 설정 E*/

        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    //트랜잭션
    @Bean
    public PlatformTransactionManager transactionManager() { //트랜잭션 관리 설정
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception { //마이바티스 사용 설정
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());

        return factoryBean.getObject();
    }

    @Bean
    public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
    //Spring JDBC 프레임워크에서 제공하는 클래스로, SQL 쿼리를 실행할 때 이름 있는 파라미터(named parameters)를 사용할 수 있게 해줌
}
