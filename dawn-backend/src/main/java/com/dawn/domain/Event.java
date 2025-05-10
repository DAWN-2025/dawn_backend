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

    @Column(name = "EVENT_SHORT_INFO", columnDefinition = "TEXT")
    private String shortInfo;

    @Column(name = "EVENT_BACKGROUND", columnDefinition = "TEXT")
    private String background;

    @Column(name = "EVENT_PROGRESS", columnDefinition = "TEXT")
    private String progress;

    @Column(name = "EVENT_MEANING", columnDefinition = "TEXT")
    private String meaning;

    @Column(name = "EVENT_SHORT_INFO_ENG", columnDefinition = "TEXT")
    private String shortInfoEng;

    @Column(name = "EVENT_BACKGROUND_ENG", columnDefinition = "TEXT")
    private String backgroundEng;

    @Column(name = "EVENT_PROGRESS_ENG", columnDefinition = "TEXT")
    private String progressEng;

    @Column(name = "EVENT_MEANING_ENG", columnDefinition = "TEXT")
    private String meaningEng;

    @Column(name = "EVENT_DATE", nullable = false)
    private LocalDateTime date;

    @Column(name = "EVENT_NATION")
    private String nation;

    @Column(name = "EVENT_NAME_ENG")
    private String nameEng;

    @Column(name = "EVENT_NATION_ENG")
    private String nationEng;

    @OneToMany(mappedBy = "event")
    @Builder.Default
    private List<Keyword> keywords = new ArrayList<>();

    @Column(name = "EVENT_IMAGE")
    private String eventImage;

    @Column(name = "EVENT_STAMP_IMAGE")
    private String eventStampImage;
}
