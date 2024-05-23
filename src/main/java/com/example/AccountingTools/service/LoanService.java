package com.example.AccountingTools.service;

import com.example.AccountingTools.model.Loan;
import com.example.AccountingTools.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }
    public Loan updateLoan(Long id, Loan loanDetails) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found with id " + id));

        loan.setName(loanDetails.getName());
        loan.setAmount(loanDetails.getAmount());
        loan.setIssueDate(loanDetails.getIssueDate());
        loan.setBank(loanDetails.getBank());
        loan.setCurrency(loanDetails.getCurrency());
        loan.setInterestRate(loanDetails.getInterestRate());
        loan.setLoanTermMonths(loanDetails.getLoanTermMonths());
        loan.setAccountedBy(loanDetails.getAccountedBy());
        loan.setPaymentType(loanDetails.getPaymentType());

        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found with id " + id));
        loanRepository.delete(loan);
    }

}