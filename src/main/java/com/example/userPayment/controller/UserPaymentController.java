package com.example.userPayment.controller;

import com.example.userPayment.dto.AuthenticationRequest;
import com.example.userPayment.services.UserPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user_payment")
public class UserPaymentController {

    private final UserPaymentService webClientService;

    @PostMapping(value = "/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(webClientService.auth(request));
    }

    @PutMapping("/payIn")
    public ResponseEntity<Double> payInUserBankAccount(@RequestParam String personalId,
                                                       @RequestParam Integer idAccount,
                                                       @RequestParam Double payment,
                                                       @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(webClientService.payIn(personalId, idAccount, payment, token));
    }

    @PutMapping("/payOut")
    public ResponseEntity<Double> payOutUserBankAccount(@RequestParam String personalId,
                                                        @RequestParam Integer idAccount,
                                                        @RequestParam Double payment,
                                                        @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(webClientService.payOut(personalId, idAccount, payment, token));
    }
}
