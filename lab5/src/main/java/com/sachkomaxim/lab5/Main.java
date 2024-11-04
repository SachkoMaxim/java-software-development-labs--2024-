package com.sachkomaxim.lab5;

import com.sachkomaxim.lab5.tariff.*;
import com.sachkomaxim.lab5.companies.*;

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
        // Initialize a MobileCompany with a set of tariffs
        MobileCompany mobileCompany = getMobileCompany();

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
        Tariff[] tariffsInServiceCostRange = mobileCompany.findTariffsInServiceCostRange(min, max);
        for (Tariff tariff : tariffsInServiceCostRange) {
            System.out.println(tariff + "; Service cost=" + tariff.getServiceCosts());
        }
    }

    /**
     * Creates and returns a MobileCompany instance populated with a variety of tariffs.
     *
     * @return A MobileCompany object containing predefined tariffs.
     */
    private static MobileCompany getMobileCompany() {
        // Initialize an array of tariffs with different characteristics
        Tariff[] tariffs = {
                new UnlimitedTariff("Успіх", 25, 500.0, 12.99, 200, true),
                new BasicTariff("Магніт", 100, 175.0, 0.0),
                new BasicTariff("Світло", 120, 190.0, 10.99),
                new PremiumTariff("Пісня", 50, 300.0, 100.4, 50),
                new UnlimitedTariff("Надія", 10, 450.0, 35.5, 300, false),
                new PremiumTariff("Сила", 200, 350.0, 0.75, 150),
                new PremiumTariff("Рух", 20, 300.0, 30.36, 100),
        };

        // Create and return a MobileCompany instance with the defined tariffs
        return new MobileCompany(tariffs);
    }
}