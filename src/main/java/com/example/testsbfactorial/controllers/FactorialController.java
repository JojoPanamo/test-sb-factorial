package com.example.testsbfactorial.controllers;

import com.example.testsbfactorial.service.FactorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class FactorialController {
    private final FactorialService factorialService;


    @PostMapping("/calculate")
    public ResponseEntity<?> calculateFactorial(@RequestBody FactorialService.FactorialRequest request) {
        if (request.getFactorial_num() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка, число должно быть больше лиюо равно 0");
        } else if (request.getFactorial_num() >= 64) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка, число слишком большое. Максимально допустипое значение: 63");
        }
        long result = factorialService.calculate(request).getResult();
        return ResponseEntity.ok(new FactorialService.FactorialResponse(result));
    }
}
