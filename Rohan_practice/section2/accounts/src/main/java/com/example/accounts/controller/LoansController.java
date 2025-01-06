package com.example.accounts.controller;

import com.example.accounts.dto.LoanDto;
import com.example.accounts.services.ILoansService;
import com.example.accounts.services.impl.LoansService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class LoansController {
    @Autowired
    private ILoansService servicee;
    @GetMapping("/fetch")
    public ResponseEntity<LoanDto> fetchLoanDetails(@RequestParam String mobileNumber){
        LoanDto ans = servicee.fetchLoan(mobileNumber);
        return ResponseEntity.ok(ans);
    }

}
