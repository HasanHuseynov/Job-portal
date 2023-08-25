package com.example.jobportal.dto.response;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTypesResponse {
    private Integer id;
    private String userTypeName;
    private List<UserResponse> user;


}
