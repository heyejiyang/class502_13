package member.dao;

import member.entities.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDao { //클래스 명이 자동으로 bean의 이름이 된다.

    /*
    DB에 저장하지 않고 임시 메모리에 저장
     */
    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member) {
      members.put(member.getEmail(),member);
    }

    public Member get(String email){
        return members.get(email);
    }
    public List<Member> getList(){
        List<Member> data = new ArrayList<>(members.values());
        return data;
    }
}
