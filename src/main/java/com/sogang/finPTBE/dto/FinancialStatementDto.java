package com.sogang.finPTBE.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FinancialStatementDto {
    String statement;
    Map<String, String> typeToValue;

    public String toString(){
        return statement + " " + typeToValue.toString();
    }
}
