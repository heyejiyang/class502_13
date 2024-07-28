package org.boardTest.global.entites;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //공통 속성을 사용할 상위 클래스
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)//수정 x, 추가만 가능해야함
    private LocalDateTime createdAt;

    @LastModifiedDate //스프링 표준적 애노테이션
    @Column(updatable = false) //수정X
    private LocalDateTime modifiedAt;
}
