package com.sogang.crawler.repository;

import com.sogang.crawler.domain.Ticker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TickerRepository extends MongoRepository<Ticker, String> {
    Ticker findTickerByTicker(String ticker);
}
