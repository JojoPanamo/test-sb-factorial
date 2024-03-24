package com.example.testsbfactorial.service;

import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialServiceTest {

    @Test
    void calculate() {
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        FactorialService factorialService = new FactorialService(meterRegistry);

        // Проверка факториала для числа 5
        assertEquals(120, factorialService.calculateFactorial(5));

        // Проверка факториала для числа 0
        assertEquals(1, factorialService.calculateFactorial(0));

        // Проверка факториала для отрицательного числа (должно быть исключение)
        assertThrows(IllegalArgumentException.class, () -> factorialService.calculateFactorial(-1));

        // Проверка факториала для числа больше 63. Должно быть выброшено исключение.
        assertThrows(IllegalArgumentException.class, () -> factorialService.calculateFactorial(64));
    }
}