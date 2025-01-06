package com.example.accounts.repository;

import com.example.accounts.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loans,Long> {
  Optional<Loans> findByMobileNumber(String mobileNumber);
}
