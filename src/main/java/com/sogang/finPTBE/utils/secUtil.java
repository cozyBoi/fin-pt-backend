package com.sogang.finPTBE.utils;

import com.sogang.finPTBE.domain.Ticker;
import com.sogang.finPTBE.repository.TickerRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class secUtil {
    private final TickerRepository tickerRepository;
    private final UrlUtil urlUtil;
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

    public String getFillingsByTicker(String ticker){
        Long cik = getCikByTicker(ticker);
        String cikStr = String.format("%10d", cik).replace(' ', '0');
        String url = "https://data.sec.gov/submissions/CIK" + cikStr + ".json";
        return urlUtil.getRequest(url);
    }

    public String getFinancialStatementByTicker(String jsonString, String ticker, String type){
        Long cik = getCikByTicker(ticker);
        try {
            JSONParser parser = new JSONParser();
            JSONObject o1, o2, o3;
            o1 = (JSONObject) parser.parse(jsonString);
            o2 = (JSONObject) o1.get("filings");
            o3 = (JSONObject) o2.get("recent");
            JSONArray o4 = (JSONArray) o3.get("form");
            JSONArray o5 = (JSONArray) o3.get("primaryDocument");
            JSONArray o6 = (JSONArray) o3.get("accessionNumber");
            String cikStr = String.format("%10d", cik).replace(' ', '0');
            String fileName =  (String) o5.get(0);
            String accessNumber = (String) o6.get(0);
            for(int i = 0; i < o4.size(); i++){
                if(o4.get(i).equals("10-K")){
                    accessNumber = (String) o6.get(i);
                    break;
                }
            }

            accessNumber = accessNumber.replace("-", "");
            String url = "https://www.sec.gov/Archives/edgar/data/" + cikStr + "/" + accessNumber + "/" + type + ".htm";

            return urlUtil.getRequest(url);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    private Long getCikByTicker(String ticker){
        Long ret = null;
        try {
            ret = tickerRepository.findTickerByTicker(ticker).getCik();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }
}
