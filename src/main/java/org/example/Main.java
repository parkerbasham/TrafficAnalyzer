/*
Developer: Parker Basham
Assignment: Reading JSON/CSV
Date: 10.07.2026

See README.md for project description.
 */

package org.example;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// The main class contains all the menu systems.
public class Main {

    // Initialize an arrayList to store streets.
    static ArrayList<Street> streets = new ArrayList<>();

    // Initialize a scanner to take user input.
    static Scanner userInput = new Scanner(System.in);

    // This variable is used to track which file was loaded in the final summary.
    static int initialChoice;

    static void loadFile() throws IOException {

        // These are the variables for the menu system.
        String menuOptions = """ 
                Street Traffic Data Analyzer
                Please choose an option (1-3):
                1 - Read CSV File
                2 - Read JSON File
                """;
        int choice = 0;
        boolean run = true;

        // This is the logic to call the proper function.
        // The while loop runs until the user terminates the session.
        while (run) {

            // Display the menu options.
            System.out.println(menuOptions);

            try {
                // Get user input.
                choice = Integer.parseInt(userInput.nextLine());
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please try again.\n");
                continue;
            }

            // Ensure choice is in range.
            if (choice < 0 || choice > 3) {
                System.out.println("\nInvalid Choice. Please try again.\n");
                continue;
            }

            // Set initial choice.
            initialChoice = choice;

            // Call the proper function based on choice.
            switch (choice) {
                case 1:
                    System.out.println("\nReading CSV File...\n");
                    FileLoader.loadCSV(streets);
                    run = false;
                    break;
                case 2:
                    System.out.println("\nReading JSON File...\n");
                    FileLoader.loadJSON(streets);
                    run = false;
                    break;
            }
        }
    }

    // This method is the menu for analyzing data.
    static void dataAnalyzerMenu() {

        // These are the variables for the menu.
        int choice = 0;
        int totalCities = 0;
        int totalStreets = 0;
        double avgSpeedLimit = 0.0;
        double avgStreetsCity = 0.0;
        String menuChoices = """
                Data Analyzer
                Please select an option (1-6)
                1 - Group records by city
                2 - Total number of cities
                3 - Total street records
                4 - Average speed limit
                5 - Average number of streets per city
                6 - City group summary
                7 - Quit
                """;

        // The while loop will run until the user terminates the session.
        while (true) {

            try {
                // Display menu options and get choice.
                System.out.println(menuChoices);
                choice = Integer.parseInt(userInput.nextLine());
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please try again.\n");;
                 continue;
            }

            // Check to see if choice is in bounds.
            if (choice < 0 || choice > 7) {
                System.out.println("\nInvalid choice. Please try again.\n");
            }

            // Call the appropriate method based on choice.
            switch (choice) {
                case 1:
                    System.out.println("\nGrouping records by city..");
                    DataAnalyzer.groupByCity(streets);
                    break;
                case 2:
                    System.out.println("\nCalculating total number of cities..");
                    totalCities = DataAnalyzer.totalCities(streets);
                    System.out.println("There are " + totalCities + " cities total.\n");
                    break;
                case 3:
                    System.out.println("\nCalculating total street records..");
                    totalStreets = DataAnalyzer.totalStreets(streets);
                    System.out.println("Total streets: " + totalStreets);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\nCalculating average speed limit..");
                    avgSpeedLimit = DataAnalyzer.averageSpeedLimit(streets);
                    System.out.print("The average speed limit across all records is: ");
                    System.out.printf("%.2f", avgSpeedLimit);
                    System.out.println(" mph\n");
                    break;
                case 5:
                    System.out.println("\nCalculating average number of streets per city..");
                    avgStreetsCity = DataAnalyzer.averageCityStreets(streets);
                    System.out.print("The avg num of streets per city is: ");
                    System.out.printf("%.2f", avgStreetsCity);
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\nSummarizing..");
                    DataAnalyzer.citySummary(streets);
                    break;
                case 7:
                    DataAnalyzer.finalSummery(initialChoice, streets);
                    System.out.println("\nGoodbye\n");
                    System.exit(0);
            }
        }
    }

    // The main method calls the menu methods.
    static void main() throws IOException {

        // Have user choose which file to load from.
        loadFile();

        // Bring up the data analyzer menu.
        dataAnalyzerMenu();
    }
}
