package com.sachkomaxim.lab6;

import com.sachkomaxim.lab6.tariff.*;
import com.sachkomaxim.lab6.companies.*;
import com.sachkomaxim.lab6.collections.*;

/**
 * The Main class demonstrates the functionality of a MobileCompany class
 * with different types of Tariffs, such as printing tariffs, calculating total
 * users, sorting tariffs by monthly fee, and finding tariffs within a specific
 * service cost range.
 */
public class Main {

    /**
     * The main method initializes various tariff objects, creates a MobileCompany,
     * and performs operations such as printing tariffs, calculating total users,
     * sorting tariffs, and finding tariffs within a specified service cost range.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create and initialize the tariff list with predefined tariffs
        TariffList<Tariff> tariffList;
        tariffList = getTariffList();

        // Create a MobileCompany instance with the initialized tariffs
        MobileCompany mobileCompany = new MobileCompany(tariffList);

        // Print all mobile tariffs in their original order
        System.out.println("All mobile tariffs unsorted:");
        mobileCompany.printAllTariffs();

        // Calculate and print the total number of users in the company
        System.out.println("\nTotal users in company: " + mobileCompany.calculateTotalUsers());

        // Sort tariffs by their monthly fee and print them
        System.out.println("\nTariffs after sorting by monthly fee:");
        mobileCompany.sortTariffsByMonthlyFee();
        mobileCompany.printAllTariffs();

        // Define the range for service costs
        double min = 349.99;
        double max = 509.99;
        // Find and print tariffs within the specified service cost range
        System.out.println("\nTariffs in service cost range [" + min + ", " + max + "]:");
        TariffList<Tariff> tariffsInServiceCostRange = mobileCompany.findTariffsInServiceCostRange(min, max);
        for (Tariff tariff : tariffsInServiceCostRange) {
            System.out.println(tariff + "; Service cost=" + tariff.getServiceCosts());
        }
    }

    /**
     * Creates and returns a TariffList populated with a variety of tariffs.
     *
     * @return A TariffList containing predefined tariffs for the mobile company.
     */
    private static TariffList<Tariff> getTariffList() {
        // Initialize a new TariffList to store various tariff objects
        TariffList<Tariff> tariffs = new TariffList<>();

        // Add different types of tariffs to the list
        tariffs.add(new UnlimitedTariff("Успіх", 25, 500.0, 12.99, 200, true));
        tariffs.add(new BasicTariff("Магніт", 100, 175.0, 0.0));
        tariffs.add(new BasicTariff("Світло", 120, 190.0, 10.99));
        tariffs.add(new PremiumTariff("Пісня", 50, 300.0, 100.4, 50));
        tariffs.add(new UnlimitedTariff("Надія", 10, 450.0, 35.5, 300, false));
        tariffs.add(new PremiumTariff("Сила", 200, 350.0, 0.75, 150));
        tariffs.add(new PremiumTariff("Рух", 20, 300.0, 30.36, 100));

        return tariffs;
    }
}