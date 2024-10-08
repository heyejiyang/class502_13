package org.choongang.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
//@Configuration
public class DBConfig2 {
    @Profile("!prod") // prod 프로파일이 아닌 경우
    //@Configuration
    @EnableTransactionManagement
    @MapperScan("org.choongang")
    @EnableJdbcRepositories("org.choongang")
    static class DBConfigDev extends AbstractJdbcConfiguration { //정적 내부클래스1
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            log.info("dev 프로파일!");

            DataSource ds = new DataSource();

            /* 연결 설정 S */
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
            ds.setUsername("SPRING");
            ds.setPassword("oracle");
            /* 연결 설정 E */

            /* 커넥션 풀 설정 S */
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);
            ds.setMinEvictableIdleTimeMillis(1000 * 60);
            ds.setTimeBetweenEvictionRunsMillis(1000 * 5);
            /* 커넥션 풀 설정 E */

            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());

            return factoryBean.getObject();
        }

        @Bean
        public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }
    }

    @Profile("prod")
    //@Configuration
    @EnableTransactionManagement
    @MapperScan("org.choongang")
    @EnableJdbcRepositories("org.choongang")
    static class DBConfigProd extends AbstractJdbcConfiguration { //정적내부클래스2

        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            log.info("prod 프로파일!");

            DataSource ds = new DataSource();

            /* 연결 설정 S */
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
            ds.setUsername("SPRING");
            ds.setPassword("oracle");
            /* 연결 설정 E */

            /* 커넥션 풀 설정 S */
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);
            ds.setMinEvictableIdleTimeMillis(1000 * 60);
            ds.setTimeBetweenEvictionRunsMillis(1000 * 5);
            /* 커넥션 풀 설정 E */

            return ds;
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource());

            return factoryBean.getObject();
        }

        @Bean
        public NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
            return new NamedParameterJdbcTemplate(dataSource);
        }
    }
}