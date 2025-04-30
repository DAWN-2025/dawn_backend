package com.dawn.location.service.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateLocationRequest {
    private String name;
    private Long eventId;
    private String address;
    private String image;
    private String info;
    private String nameEng;
    private String infoEng;
    private String addressEng;
}