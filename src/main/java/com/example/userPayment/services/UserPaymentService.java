package com.example.userPayment.services;

import com.example.userPayment.dto.AuthenticationRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;


@Service
public class UserPaymentService {

    private final WebClient webClient;

    public UserPaymentService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public String auth(AuthenticationRequest authenticationRequest) {
        return this.webClient.post()
                .uri("/auth/authenticate")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(authenticationRequest), AuthenticationRequest.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public Double payIn(String personalId, Integer idAccount, double payment, String token) {
        return this.webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .path("/users/payIn")
                        .queryParam("personalId", personalId)
                        .queryParam("idAccount", idAccount)
                        .queryParam("payment", payment)
                        .build()
                )
                .headers(h -> h.setBearerAuth(token.substring(7)))
                .retrieve()
                .bodyToMono(Double.class)
                .block();
    }

    public Double payOut(String personalId, Integer idAccount, double payment, String token) {
        return this.webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .path("/users/payOut")
                        .queryParam("personalId", personalId)
                        .queryParam("idAccount", idAccount)
                        .queryParam("payment", payment)
                        .build()
                )
                .headers(h -> h.setBearerAuth(token.substring(7)))
                .retrieve()
                .bodyToMono(Double.class)
                .block();
    }
}
