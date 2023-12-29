package com.sogang.finPTBE.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

public class HtmlParseUtil {
    public static String parse(String html, String className){
        Document document = Jsoup.parseBodyFragment(html);
        Element body = document.body();
        return body.getElementsByClass(className).text();
//        return body.getElementsByClass("pl").text();
//        return body.getElementsByClass("nump").text();
    }
}
