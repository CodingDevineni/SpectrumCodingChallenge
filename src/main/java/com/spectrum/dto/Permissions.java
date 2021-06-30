package com.spectrum.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Permissions {
    private List<Licenses> licenses;
}
