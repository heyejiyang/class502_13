package configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    //SqlSessionFactory는 MyBatis의 핵심 객체 중 하나로, SQL 세션(SqlSession)을 생성하는 역할
    private static SqlSessionFactory factory;

    static { //클래스가 로드 되면 가장 먼저 실행되는 구간
        try {
            Reader reader = Resources.getResourceAsReader("configs/mybatis-config.xml");
            //MyBatis 설정 파일(mybatis-config.xml)을 읽어 SqlSessionFactory를 초기화함

            factory = new SqlSessionFactoryBuilder().build(reader);
            //설정 파일을 바탕으로 SqlSessionFactory를 생성
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    /*
    * SqlSessionFactory를 통해 SqlSession을 생성
    * autoCommit 파라미터를 통해 자동 커밋 모드를 설정한다.
    * autoCommit이 true이면, SQL 실행 후 자동으로 커밋
    * */
    public static SqlSession getSession(boolean autoCommit){
      return factory.openSession(autoCommit); //필요할때 true/false직접 설정 가능
    }

    /*
    * 기본적으로 autoCommit을 true로 설정하여 SqlSession을 생성하는 메서드
    * */
    public static SqlSession getSession(){
        return getSession(true);
    }
}
