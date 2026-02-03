package com.practice.studentmanagement.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class StudentDto
{
    private String name;
    private String email;
}
