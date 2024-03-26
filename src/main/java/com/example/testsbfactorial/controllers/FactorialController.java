package com.example.testsbfactorial.controllers;

import com.example.testsbfactorial.service.FactorialRequest;
import com.example.testsbfactorial.service.FactorialResponse;
import com.example.testsbfactorial.service.FactorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class FactorialController {
    private final FactorialService factorialService;

    @PostMapping("/calculate")
    public ResponseEntity<FactorialResponse> calculateFactorial(@RequestBody FactorialRequest request) {
        FactorialResponse response = factorialService.calculate(request);
        return ResponseEntity.ok(response);
    }
}