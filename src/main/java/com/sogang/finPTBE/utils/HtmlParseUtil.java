package com.sogang.finPTBE.utils;

import com.sogang.finPTBE.dto.FinancialStatementDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlParseUtil {
    public static List<String> parse(String html, String className){
        Document document = Jsoup.parseBodyFragment(html);
        parseTable(document);
        Element body = document.body();
        return body.getElementsByClass(className).eachText();
    }

    private static List<FinancialStatementDto> parseTable(Document document){
        List<FinancialStatementDto> dtos = new ArrayList<>();
        Elements rowsName = document.select("th");
        Elements rows = document.select("tr");
        for(Element row : rows){
            Elements cols = row.select("td");
            Map<String, String> typeToValueMap = new HashMap<>();
            for(int i = 0; i < rowsName.size(); i++){
                String colData;
                try {
                    colData = cols.get(i).text();
                }
                catch (Exception e){
                    colData = "";
                }
                typeToValueMap.put(rowsName.get(i).text(), colData);
            }
            FinancialStatementDto dto = FinancialStatementDto.builder()
                    .statement(row.text())
                    .typeToValue(typeToValueMap)
                    .build();
            System.out.println(dto);
            dtos.add(dto);
            System.out.println("+++++++++++");
        }
        return dtos;
    }
}
