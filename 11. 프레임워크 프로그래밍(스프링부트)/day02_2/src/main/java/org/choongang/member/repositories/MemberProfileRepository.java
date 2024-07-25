package org.choongang.member.repositories;

import org.choongang.member.entites.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberProfileRepository extends JpaRepository<MemberProfile,Long> { //첫 번째에는 엔티티 타입 클래스를, 두 번째는 기본키 타입
}
