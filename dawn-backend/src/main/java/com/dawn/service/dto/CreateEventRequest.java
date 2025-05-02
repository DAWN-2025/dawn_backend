package com.dawn.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor

public class CreateEventRequest {

    private String name;
    private LocalDateTime occurDate;
    private String info;
    private String nation;
    private String category;
    private String nameEng;
    private String nationEng;
    private String categoryEng;
}
