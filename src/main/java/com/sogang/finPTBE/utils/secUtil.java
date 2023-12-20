package com.sogang.finPTBE.utils;

import com.sogang.finPTBE.domain.Ticker;
import com.sogang.finPTBE.repository.TickerRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class secUtil {
    private final String cik = "320193";
    private final TickerRepository tickerRepository;
    public void saveTickerJsonToMongo(){
        List<Ticker> tickerDocuments = new ArrayList<>();
        try {
            JSONParser parser = new JSONParser();
            JSONObject tickerObject = (JSONObject) parser.parse(new FileReader("/home/jleetmax/spring-workspace/finPT-BE/src/main/resources/company_tickers_exchange.json"));
            JSONArray tickerArray = (JSONArray) tickerObject.get("data");
            for(Object d : tickerArray){
                JSONArray data = (JSONArray) d;
                Ticker ticker = Ticker.builder()
                        .cik((Long) data.get(0))
                        .name((String) data.get(1))
                        .ticker((String) data.get(2))
                        .exchange((String) data.get(3))
                        .build();
                tickerDocuments.add(ticker);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        tickerRepository.saveAll(tickerDocuments);
    }
    private String getCikByTicker(String ticker){
        return cik;
    }
}