package com.min0.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert : insert시에 null인 필드를 제외시켜줌
@Entity
public class User {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에 연결된 DB의 numbering 전략을 따른다.
    private int id; // PK

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    @ColumnDefault("'user'")
    // DB는 RoleType이 없기 때문에
    @Enumerated(EnumType.STRING)
    private RoleType role; // 나중에 Enum으로 바꾼다.

    @CreationTimestamp  // 시간 자동 입력
    private Timestamp createDate;
}
