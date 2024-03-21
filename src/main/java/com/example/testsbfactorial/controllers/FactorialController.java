package com.example.testsbfactorial.controllers;

import com.example.testsbfactorial.service.FactorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class FactorialController {
    private final FactorialService factorialService;

    @PostMapping("/calculate")
    public @ResponseBody FactorialService.FactorialResponse calculateFactorial(@RequestBody FactorialService.FactorialRequest request) {
        return factorialService.calculate(request);
    }
}
