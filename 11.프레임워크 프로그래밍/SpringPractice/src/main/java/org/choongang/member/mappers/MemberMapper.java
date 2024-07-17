package org.choongang.member.mappers;

import org.apache.ibatis.annotations.Select;
import org.choongang.member.entities.Member;

public interface MemberMapper {
    @Select("SELECT COUNT(*) FROM MEMBER")
    long getTotal();
    int exists(String email);
    Member get(String email);
    int register(Member member);
}
