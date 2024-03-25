package com.example.testsbfactorial.controllers;

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
    public ResponseEntity<FactorialService.FactorialResponse> calculateFactorial(@RequestBody FactorialService.FactorialRequest request) {
        FactorialService.FactorialResponse response = factorialService.calculate(request);
        return ResponseEntity.ok(response);
    }
}