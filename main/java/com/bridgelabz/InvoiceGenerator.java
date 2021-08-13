package com.bridgelabz;

import java.util.ArrayList;

/* @Description- calculate fare given distance and time invoice generator should return the
 *   total fare of journey. */
public class InvoiceGenerator {
    private static final double NORMAL_MINIMUN_COST_PER_KILOMETER =10;
    private static final int NORMAL_COST_PER_TIME = 1;
    private static final double NORMAL_MINIMUN_FARE = 5;
    private static final double PREMIUM_MINIMUN_COST_PER_KILOMETER =15;
    private static final int PREMIUM_COST_PER_TIME = 2;
    private static final double PREMIUM_MINIMUN_FARE = 20;

    public double calculateFare(double distance, int time) {
        double NormaltotalFare =  distance * NORMAL_MINIMUN_COST_PER_KILOMETER  + time * NORMAL_COST_PER_TIME ;
        if(NormaltotalFare < NORMAL_MINIMUN_FARE ) {
            return  NORMAL_MINIMUN_FARE;
        }
        return NormaltotalFare;
    }
    /* @Description -the invoice generator should now take in multiple rides  and calculate total fare
     *  the invoice generator should now return total number of rides, total fare and average fare
     *  given a user id the invoice service gets the list of rides and the return the invoice */

    public InvoiceSummary  calculateFare(ArrayList<Ride> rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public double calculatePremiumFare(double distance, int time) {
        double PremiumtotalFare =  distance * PREMIUM_MINIMUN_COST_PER_KILOMETER + time * PREMIUM_COST_PER_TIME ;
        if(PremiumtotalFare < PREMIUM_MINIMUN_FARE ) {
            return  PREMIUM_MINIMUN_FARE;
        }
        return PremiumtotalFare;
    }

    public static void main(String[] args) {
        System.out.println("Welcome cab invoice generator");
    }
}