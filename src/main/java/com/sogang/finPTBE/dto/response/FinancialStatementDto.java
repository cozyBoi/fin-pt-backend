package com.sogang.finPTBE.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FinancialStatementDto {
    private String ticker;
    private List<SubFinancialStatementDto> FinancialStatements;
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
