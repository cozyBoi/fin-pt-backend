package com.sogang.crawler.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubFinancialStatementDto {
    private String statement;
    private Map<String, String> typeToValue;
}
