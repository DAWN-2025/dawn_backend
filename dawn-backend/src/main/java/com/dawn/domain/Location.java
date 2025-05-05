package com.dawn.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOCATION_TBL")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOC_SEQ")
    private Long seq;

    @Column(name = "LOC_NAME", nullable = false)
    @JoinColumn
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOC_EVENT")
    private Event event;

    @Column(name = "LOC_ADDREESS")
    private String address;

    @Column(name = "LOC_IMAGE")
    private String image;

    @OneToMany(mappedBy = "location")
    @Builder.Default
    private List<Keyword> keywords = new ArrayList<>();


    @Column(name = "LOC_SHORT_INFO")
    private String shortInfo;

    @Column(name = "LOC_HISTORIC_INFO")
    private String historicInfo;

    @Column(name = "LOC_ETIQUETTE")
    private String etiquette;

    @Column(name = "LOC_OPEN_TIME")
    private LocalDateTime openTime;

    @Column(name = "LOC_CLOSE_TIME")
    private LocalDateTime closeTime;

    @Column(name = "LOC_PHONE_NUM")
    private String phoneNum;

    @Column(name = "EXHIBITION_TIME")
    private String exhibitionTIme;

    @Column(name = "AVAILABLE")
    private String available;

    @Column(name = "TRANSLATE")
    private String translate;

    @Column(name = "LOC_NAME_ENG")
    private String nameEng;

    @Column(name = "LOC_ADDRESS_ENG")
    private String addressEng;
}
