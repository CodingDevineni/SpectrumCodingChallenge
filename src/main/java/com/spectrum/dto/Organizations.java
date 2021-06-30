package com.spectrum.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Organizations {

    private String organization;
    private Long release_count;
    private Double total_labor_hours;
    private boolean all_in_production;
    private Set<String> licenses;
    private Set<Integer> most_active_months;
}
