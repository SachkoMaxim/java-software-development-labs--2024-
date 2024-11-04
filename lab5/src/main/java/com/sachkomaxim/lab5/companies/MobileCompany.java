package com.sachkomaxim.lab5.companies;

import com.sachkomaxim.lab5.tariff.Tariff;

import java.util.Arrays;

/**
 * The MobileCompany class represents a mobile company that offers
 * various tariffs to its users (composed of Tariff objects).
 */
public class MobileCompany {

    /**
     * The array of Tariffs offered by the mobile company.
     */
    private final Tariff[] tariffs;

    /**
     * Constructs a MobileCompany object with the specified array of tariffs.
     *
     * @param tariffs The array of Tariffs to be managed by the mobile company.
     */
    public MobileCompany(Tariff[] tariffs) {
        this.tariffs = tariffs;
    }

    /**
     * Prints the details of all tariffs offered by the mobile company.
     */
    public void printAllTariffs() {
        for (Tariff tariff : tariffs) {
            System.out.println(tariff);
        }
    }

    /**
     * Calculates the total number of users across all tariffs in mobile company.
     *
     * @return The total number of users subscribed to the mobile
     *         company's tariffs.
     */
    public int calculateTotalUsers() {
        int totalUsers = 0;
        for (Tariff tariff : tariffs) {
            totalUsers += tariff.getUserCount();
        }
        return totalUsers;
    }

    /**
     * Sorts the tariffs by their monthly fee in ascending order.
     */
    public void sortTariffsByMonthlyFee() {
        Arrays.sort(tariffs);
    }

    /**
     * Finds and returns an array of tariffs with within a specified range of a total service cost.
     *
     * @param min The minimum service cost for the search range.
     * @param max The maximum service cost for the search range.
     * @return An array of Tariffs whose service costs fall within the specified range.
     */
    public Tariff[] findTariffsInServiceCostRange(double min, double max) {
        return Arrays.stream(tariffs)
                .filter(tariff -> tariff.getServiceCosts() >= min &&
                        tariff.getServiceCosts() <= max)
                .toArray(Tariff[]::new);
    }
}
