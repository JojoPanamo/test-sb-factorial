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

//    Реализация расчета факториала с использованием рекурсии

//    protected long calculateFactorial(long num) {
//        if (num < 0) {
//            throw new IllegalArgumentException("число должно быть больше либо равно 0");
//        } else if (num >= 64) {
//            // для решения проблемы вычисления факториала числа больше 63 можно воспользоваться BigInteger
//            throw new IllegalArgumentException("число слишком большое. Максимально допустипое значение: 63");
//        } else if (num == 0) {
//            return 1;
//        } else {
//            return num * calculateFactorial(num - 1);
//        }
//    }


//    Реализация расчета факториала с использованием цикла
    protected long calculateFactorial(long num) {
        if (num < 0) {
            throw new IllegalArgumentException("число должно быть больше либо равно 0");
        }if (num >= 64) {
            // для решения проблемы вычисления факториала числа больше 63 можно воспользоваться BigInteger
            throw new IllegalArgumentException("число слишком большое. Максимально допустипое значение: 63");
        } else {
            long result = 1; // начальное значение результата
            for (long i = 2; i <= num; i++) {
                result *= i; // умножаем текущий результат на следующее число
            }
            return result;
        }
    }
}