package com.sachkomaxim.lab5.tariff;

/**
 * The BasicTariff class represents a basic type of service tariff,
 * inheriting from the Tariff class and extending the functionality
 * of it.
 */
public class BasicTariff extends Tariff {

    /**
     * Minimum allowable monthly fee for basic tariff
     */
    private static final double MIN_COST = 120.0;

    /**
     * Maximum allowable monthly fee for basic tariff
     */
    private static final double MAX_COST = 270.0;

    /**
     * Constructs a BasicTariff object with the specified parameters.
     *
     * @param name              The name of the basic tariff.
     * @param userCount         The number of users subscribed to the basic tariff.
     * @param monthlyFee        The monthly subscription fee for the basic tariff.
     * @param additionalCosts   The additional costs associated with the basic tariff.
     */
    public BasicTariff(String name, int userCount, double monthlyFee, double additionalCosts) {
        super(name, userCount, monthlyFee, additionalCosts, MIN_COST, MAX_COST);
    }

    /**
     * Returns a string representation of the BasicTariff object,
     * including the class name and basic tariff details.
     *
     * @return A string containing the class name and details of
     *         the basic tariff.
     */
    @Override
    public String toString() {
        return "Tariff class: " + getClass().getSimpleName() + " " +
                "{ " + getInfo() + " }";
    }
}
