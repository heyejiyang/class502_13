package org.choongang.member.services;


import org.apache.ibatis.session.SqlSession;
import org.choongang.global.configs.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;

//객체 조립기
public class MemberServiceProvider {
    private static MemberServiceProvider instance;

    private MemberServiceProvider(){}

    public static MemberServiceProvider getInstance(){
        if(instance == null){
            instance = new MemberServiceProvider();
        }
        return instance;
    } //싱글톤

    public SqlSession getSession(){
        return DBConn.getSession();
    }

    public MemberMapper memberMapper(){
//        SqlSession session = DBConn.getSession();
        return getSession().getMapper(MemberMapper.class);
    }

    //회원가입 검증
    public JoinValidator joinValidator(){
        return new JoinValidator(memberMapper());
    }
    public JoinService joinService(){
        return new JoinService(joinValidator(), memberMapper());
    }

    public LoginValidator loginValidator(){
        return new LoginValidator(memberMapper());
    }

    public LoginService loginService(){
        return new LoginService(loginValidator(),memberMapper());
    }
}
