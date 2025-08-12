package com.kliv.spring.springprof.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountSummaryDTO {
    private String accountHolderName;
    private Double balance;
    private long accountAgeDays;
}
