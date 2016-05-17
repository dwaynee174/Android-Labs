package edu.csulb.android.mortgagecalculator;

/**
 * Created by Dhwani on 2/11/2016.
 */

// Utility Class for calculating the monthly payment
public class CalculatePaymentUtil {

    // Method for calculating monthly payment without Interest
    // P = Principal (the amount borrowed)
   // N = Number of months of the loan
   // T = Monthly taxes and insurance
    public static float paymentWithoutInterest(float p,int n,float t)
    {
        return ((p/n) + t);
    }

    // Method for calculating monthly payment with Interest
    // P = Principal (the amount borrowed)
    // N = Number of months of the loan
    // T = Monthly taxes and insurance
    // J = Monthly interest in decimal form (annual interest rate / 1200)
    public static double paymentWithInterest(float p, int n, float t, float j) {
        double exp= Math.pow(1+j,-n);
        double denominator= 1-exp;
        return ((p * (j / denominator) + t));
    }
}
