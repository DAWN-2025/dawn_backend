package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER_TBL")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ")
    private Long seq;


    @Column(name = "USER_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "USER_UID", nullable = false, unique = true)
    private String uid; //Firebase 인증 UID

}
