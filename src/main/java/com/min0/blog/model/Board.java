package com.min0.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob  // 대용량 데이터
    private String content; // 섬머노트 라이브러리 html 태그가 섞이므로 데이터가 매우 커짐

    @ColumnDefault("0")
    private int count;

    @ManyToOne(fetch = FetchType.EAGER) // Many = Board, One = User
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)  // mappedBy 연관관계의 주인이 아님(FK가 아님) -> DB에 컬럼을 만들지 말것.
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
