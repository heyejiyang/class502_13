package org.choongang.member.repositories;

import org.choongang.member.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository는 기본적인 CRUD 및 페이징 처리를 위한 메서드가 정의되어 있다.
public interface MemberRepository extends JpaRepository<Member,Long>, QuerydslPredicateExecutor<Member> {
    //JpaRepository는 2개의 지네릭 타입을 사용하는데, 첫 번째에는 엔티티 타입 클래스를 넣어주고, 두 번째는 기본키 타입을 넣어줌 //Long seq

    Member findByEmail(String email);

    List<Member> findByEmailContainingAndUserNameContainingOrderByCreatedAtDesc(String key1, String key2);

    Page<Member> findByEmailContaining(String keyword, Pageable pageable);

    @Query("SELECT m FROM Member m WHERE m.email LIKE :k1 AND m.userName LIKE :k2  ORDER BY m.createdAt DESC") //비영속성 상태 m: 별칭
    List<Member> getMembers(@Param("k1") String key1,@Param("k2") String key2);
}
