package com.sogang.finPTBE.controller;

import com.sogang.finPTBE.dto.request.TickerDto;
import com.sogang.finPTBE.dto.response.FinancialStatementDto;
import com.sogang.finPTBE.utils.SecUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/financialStatement")
public class FinancialStatementController {
    private final SecUtil secUtil;
    @GetMapping
    public ResponseEntity<List<FinancialStatementDto>> getFinancialStatement(TickerDto tickerDto){
        return ResponseEntity.ok(secUtil.getFinancialStatementByTicker(tickerDto.getTicker()));
    }
}