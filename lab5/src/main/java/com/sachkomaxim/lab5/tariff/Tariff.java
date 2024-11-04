package com.sachkomaxim.lab5.tariff;

/**
 * The Tariff class represents a service tariff with a specific name, user count,
 * monthly fee, and additional costs. Also implements the Comparable interface to
 * allow comparison of tariffs based on monthly fee.
 */
public class Tariff implements Comparable<Tariff> {

    /**
     * The name of the tariff.
     */
    protected final String name;

    /**
     * The number of users subscribed to this tariff.
     */
    protected final int userCount;

    /**
     * The monthly subscription fee for the tariff.
     */
    protected final double monthlyFee;

    /**
     * The additional costs associated with the tariff beyond the monthly fee.
     */
    protected final double additionalCosts;

    /**
     * Constructs a Tariff object with the specified parameters.
     *
     * @param name              The name of the tariff.
     * @param userCount         The number of users subscribed to the tariff.
     * @param monthlyFee        The monthly subscription fee for the tariff.
     * @param additionalCosts   The additional costs associated with the tariff.
     * @param minCost           The minimum allowable monthly fee for this tariff.
     * @param maxCost           The maximum allowable monthly fee for this tariff.
     * @throws IllegalArgumentException If userCount, monthlyFee, or additionalCosts is negative,
     *                                  or if the monthly fee is not within the specified range.
     */
    public Tariff(String name, int userCount, double monthlyFee, double additionalCosts, double minCost, double maxCost) {
        if (userCount < 0) {
            throw new IllegalArgumentException("User count cannot be less than zero");
        }

        if (monthlyFee < 0) {
            throw new IllegalArgumentException("Monthly fee cannot be less than zero");
        }

        if (additionalCosts < 0) {
            throw new IllegalArgumentException("Additional costs cannot be less than zero");
        }
        if (monthlyFee < minCost || monthlyFee > maxCost) {
            throw new IllegalArgumentException("Monthly fee must be in range " + minCost + "-" + maxCost);
        }

        this.name = name;
        this.userCount = userCount;
        this.monthlyFee = monthlyFee;
        this.additionalCosts = additionalCosts;
    }

    /**
     * Gets the name of the tariff.
     *
     * @return The name of the tariff.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of users currently subscribed to this tariff.
     *
     * @return The number of users for the tariff.
     */
    public int getUserCount() {
        return userCount;
    }

    /**
     * Gets the monthly subscription fee for the tariff.
     *
     * @return The monthly fee of the tariff.
     */
    public double getMonthlyFee() {
        return monthlyFee;
    }

    /**
     * Gets the additional costs associated with the tariff.
     *
     * @return The additional costs of the tariff.
     */
    public double getAdditionalCosts() {
        return additionalCosts;
    }

    /**
     * Calculates the total service cost for the tariff, which is the
     * sum of the monthly fee and additional costs.
     *
     * @return The total service costs of the tariff.
     */
    public double getServiceCosts() {
        return monthlyFee + additionalCosts;
    }

    /**
     * Compares this tariff with another based on the monthly fee.
     *
     * @param other Another tariff for comparison.
     * @return A negative integer, zero, or a positive integer as this tariff's monthly fee
     *         is less than, equal to, or greater than the other tariff's monthly fee.
     */
    @Override
    public int compareTo(Tariff other) {
        return Double.compare(this.monthlyFee, other.monthlyFee);
    }

    /**
     * Get information about the tariff.
     *
     * @return A string containing the tariff's details including name,
     *         user count, monthly fee, and additional costs.
     */
    protected String getInfo() {
        return "name='" + name + '\'' +
                ", users count=" + userCount +
                ", monthly fee=" + monthlyFee +
                ", additional costs=" + additionalCosts;
    }
}
