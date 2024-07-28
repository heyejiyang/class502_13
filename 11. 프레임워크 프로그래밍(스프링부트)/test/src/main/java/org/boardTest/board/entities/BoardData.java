package org.boardTest.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.boardTest.global.entites.BaseEntity;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseEntity {
    @Id
    @GeneratedValue
    private Long seq;
    @Column(nullable = false)
    private String subject;
    @Lob
    private String content;
    @Column(nullable = false)
    private String writer;
}
