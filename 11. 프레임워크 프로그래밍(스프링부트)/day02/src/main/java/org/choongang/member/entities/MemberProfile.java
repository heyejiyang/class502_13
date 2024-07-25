package org.choongang.member.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class MemberProfile {
    @Id @GeneratedValue
    private Long seq;

    private String profileImage;
    private String status;

    @ToString.Exclude
    @OneToOne(mappedBy = "profile")
    private Member member;
}
