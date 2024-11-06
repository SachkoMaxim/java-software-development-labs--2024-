package com.sachkomaxim.lab6.companies;

import com.sachkomaxim.lab6.tariff.Tariff;
import com.sachkomaxim.lab6.collections.TariffList;

/**
 * The MobileCompany class represents a mobile company that offers
 * various tariffs to its users (composed of Tariff objects).
 */
public class MobileCompany {

    /**
     * The list of Tariffs offered by the mobile company.
     */
    private final TariffList<Tariff> tariffs;

    /**
     * Constructs a MobileCompany object with the specified list of tariffs.
     *
     * @param tariffs The list of Tariffs to be managed by the mobile company.
     */
    public MobileCompany(TariffList<Tariff> tariffs) {
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
        tariffs.sort(Tariff::compareTo);
    }

    /**
     * Finds and returns a list of tariffs with within a specified range of a total service cost.
     *
     * @param min The minimum service cost for the search range.
     * @param max The maximum service cost for the search range.
     * @return A list of Tariffs whose service costs fall within the specified range.
     */
    public TariffList<Tariff> findTariffsInServiceCostRange(double min, double max) {
        TariffList<Tariff> result = new TariffList<>();

        for (Tariff tariff : tariffs) {
            if (tariff.getServiceCosts() >= min && tariff.getServiceCosts() <= max) {
                result.add(tariff);
            }
        }

        return result;
    }
}
