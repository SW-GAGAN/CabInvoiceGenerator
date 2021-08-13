package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTrue(){
        InvoiceGenerator invoiceGenator =new InvoiceGenerator();
        double distance = 2.0;
        int time =5;
        double fare = invoiceGenator.calculateFare(distance, time);
        Assertions.assertEquals(25,fare,0.0);
    }
}

