package com.kliv.spring.springprof.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Account {
    private Long id;
    private String accountHolderName;
    private String accountNumber;
    private Double balance;
    private Boolean kycVerified;
    private String branchName;
    private LocalDate openedDate;
    private String accountType;
}