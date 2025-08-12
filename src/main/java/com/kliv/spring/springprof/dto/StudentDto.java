package com.kliv.spring.springprof.dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private AddressDto address;
    private MultipartFile pdf;

}
