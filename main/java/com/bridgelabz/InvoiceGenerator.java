package com.bridgelabz;

public class InvoiceGenerator {

    private final double COST_PER_KILOMETER = 10;
    private final int COST_PER_MINUTE = 1;
    public double calculateFare(double distance, int time) {
        return (distance * COST_PER_KILOMETER + time * COST_PER_MINUTE);
    }
    }

