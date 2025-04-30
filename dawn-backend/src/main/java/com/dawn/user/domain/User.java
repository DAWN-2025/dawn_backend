package com.dawn.user.domain;

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
    private Long id;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String uid; //Firebase 인증 UID

}
