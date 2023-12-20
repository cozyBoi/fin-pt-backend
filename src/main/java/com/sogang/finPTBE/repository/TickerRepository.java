package com.sogang.finPTBE.repository;

import com.sogang.finPTBE.domain.Ticker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TickerRepository extends MongoRepository<Ticker, String> {
}
