package com.kliv.spring.springprof.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private AddressDto address;

}
