package com.sogang.finPTBE.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
public class UrlUtil {
    final int retryMax = 5;
    public String getRequest(String url) {
        return getRequest(url, 0);
    }

    public String getRequest(String url, int retryCount){
        if(retryCount >= retryMax) return null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URL(url).toURI())
                    .headers("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .headers("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36")
                    .version(HttpClient.Version.HTTP_2)
                    .timeout(Duration.of(10, ChronoUnit.SECONDS))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .proxy(ProxySelector.getDefault())
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(isRedirect(response.statusCode())){
                return getRequest(response.headers().firstValue("location").orElseThrow(), retryCount + 1);
            }

            return response.body();
        } catch (IOException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isRedirect(int code){
        return code / 100 == 3;
    }
}
