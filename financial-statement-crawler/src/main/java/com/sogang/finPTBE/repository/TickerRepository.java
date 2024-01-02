package com.sogang.finPTBE.repository;

import com.sogang.finPTBE.domain.Ticker;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TickerRepository extends MongoRepository<Ticker, String> {
    Ticker findTickerByTicker(String ticker);
}
