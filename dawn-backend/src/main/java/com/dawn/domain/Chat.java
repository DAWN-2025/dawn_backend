package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "CHAT_TBL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAT_SEQ")
    private Long chatSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHAT_USER")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHAT_LOC")
    private Location location;

    @Column(name = "CHAT_TARGET")
    private String chatTarget;

    @Column(name = "CHAT_QUESTION")
    private String chatQuestion;

    @Column(name = "CHAT_ANSWER")
    private String chatAnswer;
}
