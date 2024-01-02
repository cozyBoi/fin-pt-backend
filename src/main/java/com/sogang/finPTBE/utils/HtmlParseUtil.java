package com.sogang.finPTBE.utils;

import com.sogang.finPTBE.dto.response.FinancialStatementDto;
import com.sogang.finPTBE.dto.response.SubFinancialStatementDto;
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
        Element body = document.body();
        return body.getElementsByClass(className).eachText();
    }

    public static FinancialStatementDto parseTable(String html){
        Document document = Jsoup.parseBodyFragment(html);
        Element body = document.selectFirst("tbody");
        List<SubFinancialStatementDto> dtos = new ArrayList<>();
        Elements rowsName = body.select("th");
        Elements rows = body.select("tr");
        for(Element row : rows){
            Elements cols = row.select("td");
            Map<String, String> typeToValueMap = new HashMap<>();
            String statement = row.getElementsByClass("pl").text();
            statement = statement.isEmpty() ? row.getElementsByClass("pl custom").text() : statement;
            for(int i = 0; i < rowsName.size(); i++){
                String colData, rowData = rowsName.get(i).text();
                try {
                    colData = cols.get(i).text();
                }
                catch (Exception e){
                    colData = "";
                }
                if(colData.equals(statement)) continue;
                typeToValueMap.put(rowData, colData);
            }
            SubFinancialStatementDto dto = SubFinancialStatementDto.builder()
                    .statement(statement)
                    .typeToValue(typeToValueMap)
                    .build();
            dtos.add(dto);
        }
        return FinancialStatementDto.builder()
                .FinancialStatements(dtos)
                .build();
    }
}
