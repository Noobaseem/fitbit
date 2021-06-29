package com.udaan.interview.fitbit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeartResponse {
    private Double maxValue;
    private Double minValue;
    private Double avgValue;
}
