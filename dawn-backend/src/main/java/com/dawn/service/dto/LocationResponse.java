package com.dawn.service.dto;

import com.dawn.domain.Location;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LocationResponse {
    private Long id;
    private String name;
    private String address;
    private String image;
    private String info;
    private String nameEng;
    private String infoEng;
    private String addressEng;

    public static LocationResponse from(Location loc) {
        return LocationResponse.builder()
                .id(loc.getSeq())
                .name(loc.getName())
                .address(loc.getAddress())
                .image(loc.getImage())
                .info(loc.getInfo())
                .nameEng(loc.getNameEng())
                .infoEng(loc.getInfoEng())
                .addressEng(loc.getAddressEng())
                .build();
    }
}