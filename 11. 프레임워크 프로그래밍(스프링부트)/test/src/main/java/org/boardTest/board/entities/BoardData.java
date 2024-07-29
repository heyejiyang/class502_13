package org.boardTest.board.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @Column(length = 30, nullable = false)
    private String subject;
    @Lob
    private String content;
    @Column(length = 10, nullable = false)
    private String writer;
}
