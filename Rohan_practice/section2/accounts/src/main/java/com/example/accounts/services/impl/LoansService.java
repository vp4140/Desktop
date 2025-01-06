package com.example.accounts.services.impl;

import com.example.accounts.constants.LoansConstant;
import com.example.accounts.dto.LoanDto;
import com.example.accounts.entity.Loans;
import com.example.accounts.mapper.LoansMapper;
import com.example.accounts.repository.LoanRepository;
import com.example.accounts.services.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansService implements ILoansService {
    @Autowired
    private LoanRepository repository;


    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> val = repository.findByMobileNumber(mobileNumber);
        if (val.isPresent()){
//            throw new Exception("Loan already registered with given mobileNumber "+mobileNumber);
        }else {
            repository.save(createNewLoan(mobileNumber));
        }

    }
    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstant.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstant.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstant.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoanDto fetchLoan(String mobileNumber) {
        Loans loans = repository.findByMobileNumber(mobileNumber).orElse(null);
        //lets implement exception handler

        return LoansMapper.mapToLoansDto(loans,new LoanDto());
    }

    @Override
    public boolean updateLoan(LoanDto loansDto) {
        return false;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        return false;
    }
}
