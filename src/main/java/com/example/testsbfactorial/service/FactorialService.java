package com.example.testsbfactorial.service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactorialService {
    private final MeterRegistry meterRegistry;

    public FactorialResponse calculate(FactorialRequest request) {
        Timer.Sample sample = Timer.start(meterRegistry);
        long result = calculateFactorial(request.getFactorial_num());
        sample.stop(Timer.builder("factorial.calculation.time")
                .description("Time taken to calculate factorial")
                .tag("factorial", String.valueOf(request.getFactorial_num()))
                .register(meterRegistry));
        return new FactorialResponse(result);
    }

    protected long calculateFactorial(long num) {
        if (num < 0) {
            throw new IllegalArgumentException("число должно быть больше либо равно 0");
        }
        if (num >= 64) {
            // для решения проблемы вычисления факториала числа больше 63 можно воспользоваться BigInteger
            throw new IllegalArgumentException("число слишком большое. Максимально допустипое значение: 63");
        } else if (num == 0) {
            return 1;
        } else {
            return num * calculateFactorial(num - 1);
        }
    }

    public static class FactorialRequest {
        private long factorial_num;

        public long getFactorial_num() {
            return factorial_num;
        }

        public void setFactorial_num(long factorial_num) {
            this.factorial_num = factorial_num;
        }
    }

    public static class FactorialResponse {
        private long result;

        public FactorialResponse(long result) {
            this.result = result;
        }

        public long getResult() {
            return result;
        }

        public void setResult(long result) {
            this.result = result;
        }
    }
}

