package com.sogang.crawler.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

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
