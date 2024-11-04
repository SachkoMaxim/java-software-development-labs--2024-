package com.sachkomaxim.lab5.tariff;

/**
 * The BasicTariff class represents a basic type of service tariff,
 * inheriting from the Tariff class and extending the functionality
 * of it.
 */
public class BasicTariff extends Tariff {

    /**
     * Constructs a BasicTariff object with the specified name, user count,
     * monthly fee, and additional costs.
     *
     * @param name              The name of the basic tariff.
     * @param userCount         The number of users subscribed to the basic tariff.
     * @param monthlyFee        The monthly subscription fee for the basic tariff.
     * @param additionalCosts   The additional costs associated with the basic tariff.
     */
    public BasicTariff(String name, int userCount, double monthlyFee, double additionalCosts) {
        super(name, userCount, monthlyFee, additionalCosts);
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
