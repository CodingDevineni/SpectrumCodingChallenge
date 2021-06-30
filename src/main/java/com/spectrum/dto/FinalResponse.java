package com.spectrum.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class FinalResponse {
    private List<Organizations> organizations;
}
