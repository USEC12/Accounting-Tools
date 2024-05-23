package com.example.AccountingTools.repositories;

import com.example.AccountingTools.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // можно добавить кастомные методы

}