package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "KEYWORD_TBL")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KEYWORD_SEQ")
    private Long seq;

    @Column(name = "KEYWORD", nullable = false)
    private String keyword;

    @Column(name = "KEYWORD_ENG", nullable = false)
    private String keywordEng;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KEYWORD_EVENT")
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KEYWORD_LOCATION")
    private Location location;

    @Column(name = "KEYWORD_KOR_ENG")
    private Integer korEngFlag;
}
