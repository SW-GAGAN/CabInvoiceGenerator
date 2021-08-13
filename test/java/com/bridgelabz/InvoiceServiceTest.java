package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.2;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
        ArrayList<Ride> rides = new ArrayList<Ride>();
        rides.add(new Ride(2.0, 5));
        rides.add(new Ride(0.1, 1));
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary exceptedinvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(exceptedinvoiceSummary, summary);

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary1() {
        InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
        RideRepository riderepo = new RideRepository();
        riderepo.addRidetoUser("User", new Ride(2.0, 5));
        riderepo.addRidetoUser("User", new Ride(0.1, 1));
        InvoiceSummary summary = invoiceGenerator.calculateFare(riderepo.getRides("User"));
        InvoiceSummary exceptedinvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(exceptedinvoiceSummary, summary);
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnpremiumMinFare() {
        double distance = 0.5;
        int time = 4;
        InvoiceGenerator invoiceGenerator = null;
        double fare = invoiceGenerator.calculatePremiumFare(distance, time);
        Assertions.assertEquals(20, fare, 0.0);
    }
}