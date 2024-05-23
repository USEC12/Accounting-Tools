package com.example.AccountingTools.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.AccountingTools.model.Loan;
import com.example.AccountingTools.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class LoanControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();
    }

    @Test
    public void testGetAllLoans() throws Exception {
        Loan loan = new Loan(); // Добавить инициализацию полей
        given(loanService.getAllLoans()).willReturn(Arrays.asList(loan));

        mockMvc.perform(get("/api/loans"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetLoanById() throws Exception {
        Loan loan = new Loan(); // Добавить инициализацию полей
        given(loanService.getLoanById(1L)).willReturn(Optional.of(loan));

        mockMvc.perform(get("/api/loans/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateLoan() throws Exception {
        Loan loan = new Loan(); // Добавить инициализацию полей
        given(loanService.createLoan(any(Loan.class))).willReturn(loan);

        mockMvc.perform(post("/api/loans")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loan)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateLoan() throws Exception {
        Loan existingLoan = new Loan(); // Добавить инициализацию полей
        Loan updatedLoan = new Loan(); // Добавить инициализацию полей
        given(loanService.updateLoan(eq(1L), any(Loan.class))).willReturn(updatedLoan);

        mockMvc.perform(put("/api/loans/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedLoan)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteLoan() throws Exception {
        mockMvc.perform(delete("/api/loans/1"))
                .andExpect(status().isOk());
        verify(loanService, times(1)).deleteLoan(1L);
    }

    // Здесь могут быть добавлены дополнительные тесты для ошибок, невалидных запросов и т.д.
}