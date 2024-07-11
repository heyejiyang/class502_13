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
        /*커넥션 풀 설정 E*/
    }
}
