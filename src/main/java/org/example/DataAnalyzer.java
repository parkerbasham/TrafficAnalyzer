/*
This class contains all the methods to analyze the
street data loaded into the streets arraylist.

NOTE: commented out lines of code are there because
my original design was all void methods. But I realized
that latter methods could use the output of some of the
earlier ones, so I made them return values.
 */

package org.example;

import java.util.*;

public class DataAnalyzer {

    // This helper method creates a city arraylist
    // to be used by the other methods.
    static ArrayList<String> loadCities(ArrayList<Street> theAL) {

        // Create an arraylist to hold each city once.
        ArrayList<String> loadedCities = new ArrayList<>();

        // Add each city to the arraylist once.
        for (Street s : theAL) {
            if (!loadedCities.contains(s.getCity())) {
                loadedCities.add(s.getCity());
            }
        }

        // Sort the arraylist alphabetically.
        Collections.sort(loadedCities);

        // Return loadedCities.
        return loadedCities;
    }

    // This method displays the records grouped by city.
    static void groupByCity(ArrayList<Street> theAL) {

        // Create an arraylist to hold cities.
        ArrayList<String> citiesToGroup = loadCities(theAL);

        // Iterate through citiesToGroup to determine what city to group by.
        for (String c : citiesToGroup) {

            // Display the city we are grouping under.
            System.out.println("\n" + c);

            // Iterate through the arraylist to compare cities.
            for (Street s : theAL) {

                // Print the streets that match current city.
                if (s.getCity().equals(c)) {
                    System.out.println("    " + s.getStreetName());
                }

            } // End of for each theAL.
        } // End of for each citiesToGroup.
        System.out.println();
    } // End of groupByCity method.

    // This method calculates the total number of cities in the records.
    static int totalCities(ArrayList<Street> theAL) {

        // This variable is used to count cities.
        int numCities = 0;

        ArrayList<String> cities = loadCities(theAL);

        // Set numCities.
        numCities = cities.size();

        // Display cities to the user.
//        System.out.println("\nThere are " + numCities + " cities total.\n");

        // return number of cities.
        return numCities;
    }

    // This method calculates the total number of street records.
    static int totalStreets(ArrayList<Street> theAL) {

        // This variable is used to count streets.
        int numStreets = 0;

        // Iterate through the arraylist and increment.
        // NOTE: you could just set numStreets == theAL.size().
        for (Street s : theAL) {
            numStreets++;
        }

        // Display total street records.
//        System.out.println("Total streets: " + numStreets);

        // Return number of streets.
        return numStreets;
    }

    // This method calculates the average speed limit
    // across all street records.
    static double averageSpeedLimit(ArrayList<Street> theAL) {

        // These are the variables to calculate average speed limit.
        double avgSpeedLimit = 0.0;
        double sum = 0.0;
        double totalRecords = theAL.size();

        // Get the sum of all speed limits.
        for (Street s : theAL) {
            sum = sum + s.getSpeedLimit();
        }

//        System.out.println("Sum: " + sum + " Total: " + totalRecords);

        // Divide the sum by the total number of records.
        avgSpeedLimit = sum / totalRecords;

        // Display the average speed limit to the user.
//        System.out.print("\nThe average speed limit across all records is: ");
//        System.out.printf("%.2f", avgSpeedLimit); // Round to two decimal places.
//        System.out.println(" mph");

        // Return average speed limit.
        return avgSpeedLimit;
    }

    // This method calculates the average number of streets per city.
    static double averageCityStreets(ArrayList<Street> theAL) {

        // Average streets per city = total streets divided by total cities.
        double numStreets = totalStreets(theAL);
        double numCities = totalCities(theAL);
        double avgStreetsCity = 0.0;

//        System.out.println("Streets: " + numStreets + " Cities: " + numCities);

        // Calculate the average streets per city.
        avgStreetsCity = numStreets / numCities;

//        System.out.print("\nThe avg num of streets per city is: ");
//        System.out.printf("%.2f", avgStreetsCity);

        return avgStreetsCity;
    }

    // This method displays a summary of each city.
    static void citySummary(ArrayList<Street> theAL) {

        // Create an arraylist to hold cities.
        ArrayList<String> cities = loadCities(theAL);

        // These are the variables to display the summary.
        int population = 0;
        int streets = 0;
        double speedSum = 0.0;
        double avgSpeedLimit = 0.0;
        int counter = 0;

        // Print the summary header.
        System.out.println("\nCITY SUMMARY");
        System.out.println("----------------------------------------------------------");
        System.out.println("    City    Population   Streets  Avg Speed Limit");
        System.out.println("----------------------------------------------------------");

        for (String c : cities) {

            // set values
            for (Street s : theAL) {
                if (s.getCity().equals(c)) {
                    population = s.cityPopulation; // todo: make not redundant??
                    streets++;
                    speedSum = speedSum + s.getSpeedLimit();
                }
            }

            // Calculate avg speed limit.
            avgSpeedLimit = speedSum / streets;
            counter++;

            // Display the summary.
            System.out.print(counter + ": ");
            System.out.print(c);
            System.out.print("    " + population);
            System.out.print("    " + streets + "    ");
            System.out.printf("%.2f", avgSpeedLimit);
            System.out.println();
        }
        // Spacing.
        System.out.println();
    }

    // This method prints the final summary for the session.
    static void finalSummery(int choice, ArrayList<Street> theAl) {

        // These are the variables for the final summary.
        String fileType = "";
        int numCities = totalCities(theAl);
        int numStreets = totalStreets(theAl);
        double avgSpeedLimit = averageSpeedLimit(theAl);
        double avgCityStreets = averageCityStreets(theAl);

        // Set file type.
        if (choice == 1) {
            fileType = "CSV";
        } else {
            fileType = "JSON";
        }

        // Display the final summary.
        System.out.println("\n=======================================");
        System.out.println("STREET TRAFFIC DATA SUMMARY");
        System.out.println("=======================================");
        System.out.println("File Type: " + fileType);
        System.out.println("Number of Cities: " + numCities);
        System.out.println("Number of Streets: " + numStreets);
        System.out.print("Average Speed Limit: ");
        System.out.printf("%.2f", avgSpeedLimit);
        System.out.println();
        System.out.print("Average Streets per City: ");
        System.out.printf("%.2f", avgCityStreets);
        System.out.println();
        System.out.println("=======================================\n");


    }


}
