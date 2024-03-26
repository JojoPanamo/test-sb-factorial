package com.example.testsbfactorial.service;

public class FactorialResponse {
    private final long result;

    public FactorialResponse(long result) {
        this.result = result;
    }

    public long getResult() {
        return result;
    }
}