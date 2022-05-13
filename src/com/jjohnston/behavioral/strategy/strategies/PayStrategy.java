package com.jjohnston.behavioral.strategy.strategies;

/**
 * The strategy interface declares operations common to all
 * supported versions of some algorithm. The context uses this
 * interface to call the algorithm defined by the concrete
 * strategies.
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
