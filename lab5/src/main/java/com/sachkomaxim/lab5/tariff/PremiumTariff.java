package com.sachkomaxim.lab5.tariff;

/**
 * The PremiumTariff class represents a premium type of service tariff,
 * inheriting from the Tariff class and including extra minutes on top
 * of the standard tariff details.
 */
public class PremiumTariff extends Tariff {

    /**
     * Minimum allowable monthly fee for premium tariff
     */
    private static final double MIN_COST = 270.0;

    /**
     * Maximum allowable monthly fee for premium tariff
     */
    private static final double MAX_COST = 420.0;

    /**
     * The additional minutes included in the premium tariff.
     */
    private final int extraMinutes;

    /**
     * Constructs a PremiumTariff object with the specified parameters.
     *
     * @param name              The name of the premium tariff.
     * @param userCount         The number of users subscribed to the premium tariff.
     * @param monthlyFee        The monthly subscription fee for the premium tariff.
     * @param additionalCosts   The additional costs associated with the premium tariff.
     * @param extraMinutes      The number of extra minutes included in the premium tariff.
     */
    public PremiumTariff(String name, int userCount, double monthlyFee, double additionalCosts, int extraMinutes) {
        super(name, userCount, monthlyFee, additionalCosts, MIN_COST, MAX_COST);
        this.extraMinutes = extraMinutes;
    }

    /**
     * Gets the extra minutes included in the premium tariff.
     *
     * @return The number of extra minutes for the premium tariff.
     */
    public int getExtraMinutes() {
        return extraMinutes;
    }

    /**
     * Returns a string representation of the PremiumTariff object,
     * including the class name, tariff details, and extra minutes.
     *
     * @return A string containing the class name, details of the
     *         premium tariff, and extra minutes.
     */
    @Override
    public String toString() {
        return "Tariff class: " + getClass().getSimpleName() + " " +
                "{ " + getInfo() + ", extra minutes=" + this.extraMinutes + " }";
    }
}
