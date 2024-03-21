package com.example.testsbfactorial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactorialService {
    public static class FactorialRequest {
        private int factorial_num;

        public int getFactorial_num() {
            return factorial_num;
        }

        public void setFactorial_num(int factorial_num) {
            this.factorial_num = factorial_num;
        }
    }

    public static class FactorialResponse {
        private int result;

        public FactorialResponse(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }
    }

    public FactorialResponse calculate(FactorialRequest request) {
        int result = calculateFactorial(request.getFactorial_num());
        return new FactorialResponse(result);
    }

    private int calculateFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }
}

