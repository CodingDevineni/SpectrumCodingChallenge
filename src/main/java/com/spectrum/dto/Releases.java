package com.spectrum.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Releases {

    private String organization;
    private Double laborHours;
    private String status;
    private Permissions permissions;
    private ReleaseDates date;



}
