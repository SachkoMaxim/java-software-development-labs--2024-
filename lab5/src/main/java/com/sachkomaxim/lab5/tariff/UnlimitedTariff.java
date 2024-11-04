package com.sachkomaxim.lab5.tariff;

/**
 * The UnlimitedTariff class represents an unlimited service tariff,
 * inheriting from the Tariff class and including extra minutes and
 * optional international calling capabilities on top of the
 * standard tariff details.
 */
public class UnlimitedTariff extends Tariff {

    /**
     * Minimum allowable monthly fee for unlimited tariff
     */
    private static final double MIN_COST = 420.0;

    /**
     * Maximum allowable monthly fee for unlimited tariff
     */
    private static final double MAX_COST = 900.0;

    /**
     * The additional minutes included in the unlimited tariff.
     */
    private final int extraMinutes;

    /**
     * Indicates whether international calls are allowed with this tariff.
     */
    private final boolean internationalCalls;

    /**
     * Constructs an UnlimitedTariff object with the specified parameters.
     *
     * @param name                  The name of the unlimited tariff.
     * @param userCount             The number of users subscribed to the unlimited tariff.
     * @param monthlyFee            The monthly subscription fee for the unlimited tariff.
     * @param additionalCosts       The additional costs associated with the unlimited tariff.
     * @param extraMinutes          The number of extra minutes included in the unlimited tariff.
     * @param internationalCalls    Indicates if international calls are allowed with the unlimited tariff.
     */
    public UnlimitedTariff(String name, int userCount, double monthlyFee, double additionalCosts, int extraMinutes, boolean internationalCalls) {
        super(name, userCount, monthlyFee, additionalCosts, MIN_COST, MAX_COST);
        this.extraMinutes = extraMinutes;
        this.internationalCalls = internationalCalls;
    }

    /**
     * Gets the extra minutes included in the unlimited tariff.
     *
     * @return The number of extra minutes for the unlimited tariff.
     */
    public int getExtraMinutes() {
        return extraMinutes;
    }

    /**
     * Checks if international calls are allowed with the unlimited tariff.
     *
     * @return True if international calls are allowed;
     *         false otherwise.
     */
    public boolean hasInternationalCalls() {
        return internationalCalls;
    }

    /**
     * Returns a string representation of the UnlimitedTariff object,
     * including the class name, tariff details, extra minutes, and
     * international calling option.
     *
     * @return A string containing the class name, details of the
     *         unlimited tariff, extra minutes, and international
     *         calling option.
     */
    @Override
    public String toString() {
        return "Tariff class: " + getClass().getSimpleName() + " " +
                "{ " + getInfo() + ", extra minutes=" + this.extraMinutes +
                ", international calls=" + this.internationalCalls + " }";
    }
}
