package com.example.Trips.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiStepRequest {
    private String date_start_1;
    private String date_end_1;
    private String cityname1;
    private String date_start_2;
    private String date_end_2;
    private String cityname2;
    private String date_start_trip;
    private String date_end_trip;
    private String description;
}
