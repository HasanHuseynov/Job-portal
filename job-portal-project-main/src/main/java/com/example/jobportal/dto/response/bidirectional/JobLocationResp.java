package com.example.jobportal.dto.response.bidirectional;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobLocationResp {
    private Integer jobLocationId;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zip;


}
