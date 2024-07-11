package org.choongang.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class DBConfig {
    @Bean
    public DataSource dataSource() {

        DataSource ds = new DataSource();

        /*연결 설정 S*/
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        ds.setUsername("SPRING");
        ds.setPassword("oracle");
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
}
