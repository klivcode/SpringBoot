package com.kliv.spring.springprof.controller;


import com.kliv.spring.springprof.dto.Account;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final List<Account> accounts = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Create single account with default openedDate if missing
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        if (account.getOpenedDate() == null) {
            account.setOpenedDate(LocalDate.now());
        }
        account.setId(idGenerator.getAndIncrement());
        accounts.add(account);
        return account;
    }

    // Create multiple accounts
    @PostMapping("/batch")
    public List<Account> createAccountsBatch(@RequestBody List<Account> newAccounts) {
        for (Account account : newAccounts) {
            if (account.getOpenedDate() == null) {
                account.setOpenedDate(LocalDate.now());
            }
            account.setId(idGenerator.getAndIncrement());
            accounts.add(account);
        }
        return newAccounts;
    }

    // Search by branchName and accountType
    @GetMapping("/search")
    public List<Account> search(@RequestParam(required = false) String branchName,
                                @RequestParam(required = false) String accountType) {
        return accounts.stream()
                .filter(acc -> (branchName == null || branchName.equalsIgnoreCase(acc.getBranchName())))
                .filter(acc -> (accountType == null || accountType.equalsIgnoreCase(acc.getAccountType())))
                .collect(Collectors.toList());
    }

    // Paginated accounts
    @GetMapping("/page")
    public List<Account> getPage(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        int start = page * size;
        if (start >= accounts.size()) return Collections.emptyList();
        int end = Math.min(start + size, accounts.size());
        return accounts.subList(start, end);
    }

    // Find by accountHolderName containing keyword (case-insensitive)
    @GetMapping("/find")
    public List<Account> findByName(@RequestParam String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return accounts.stream()
                .filter(acc -> acc.getAccountHolderName() != null &&
                        acc.getAccountHolderName().toLowerCase().contains(lowerKeyword))
                .collect(Collectors.toList());
    }
}