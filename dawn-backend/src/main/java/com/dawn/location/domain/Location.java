package com.dawn.location.domain;

import com.dawn.event.domain.Event;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LOCATION_TBL")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(name = "LOC_INFO")
    private String info;

    @Column(name = "LOC_NAME_ENG")
    private String nameEng;

    @Column(name = "LOC_INFO_ENG")
    private String infoEng;

    @Column(name = "LOC_ADDRESS_ENG")
    private String addressEng;
}
