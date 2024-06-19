package org.choongang.member.services;


import org.choongang.member.validators.JoinValidator;

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

    //회원가입 검증
    public JoinValidator joinValidator(){
        return new JoinValidator();
    }
    public JoinService joinService(){
        return new JoinService(joinValidator());
    }
}
