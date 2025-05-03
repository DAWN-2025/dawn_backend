package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EVENT_TBL")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_SEQ")
    private Long seq;

    @Column(name = "EVENT_NAME", nullable = false)
    private String name;

    @Column(name = "EVENT_INFO")
    private String info;

    @Column(name = "EVENT_DATE", nullable = false)
    private LocalDateTime date;

    @Column(name = "EVENT_NATION")
    private String nation;

    @Column(name = "EVENT_CATEGORY")
    private String category;

    @Column(name = "EVENT_NAME_ENG")
    private String nameEng;

    @Column(name = "EVENT_NATION_ENG")
    private String nationEng;

    @Column(name = "EVENT_CATEGORY_ENG")
    private String categoryEng;

    @OneToMany(mappedBy = "event")
    @Builder.Default
    private List<Keyword> keywords = new ArrayList<>();





}
