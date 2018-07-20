package com.mycomp.service;


import com.mycomp.mock.MockApplication;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

public class KeepAliveWatchdog {


    @Scheduled(cron = "0 0/5 * * * ?")
    public void print() {
//        CloseableHttpClient httpClient = HttpClientBuilder
//                .create()
//                .build();
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        RestTemplate restTemplate = new RestTemplate(factory);


        String url = System.getenv("UrlToKeepAlive");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println(response.toString());
    }


}