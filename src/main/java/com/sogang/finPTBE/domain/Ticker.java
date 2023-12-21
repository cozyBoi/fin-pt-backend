package com.sogang.finPTBE.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
public class Ticker {
    @Id
    public String id;
    public Long cik;
    public String name;
    public String ticker;
    public String exchange;
}
