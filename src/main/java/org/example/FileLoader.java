/*
The FileLoader class contains the methods
to load street data from either the JSON
or the CSV file.
 */

package org.example;

// These are the imports for reading csv.
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// These are the imports for reading json.
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;



public class FileLoader {

    // These are the variables to create a new street object.
    static int streetID;
    static String city;
    static int cityPopulation;
    static String streetName;
    static int carsTraveledDaily;
    static int speedLimit;

    public static void loadCSV(ArrayList<Street> theAL) {

        // These are the variables for the ReadCSV class.
        String csvFilePath = "city_street_traffic_50000.csv";
        String line = "";
        String delimiter = ",";

        // Instantiate an array to store individual values.
        String[] values;

        // Parse the csv file using a buffered reader.
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

            // Skip the header of the csv file.
            br.readLine();

            // The while loop runs as long as there
            // is another line of data in the csv file.
            while ((line = br.readLine()) != null) {

                // Add the values from the line to an array.
                values = line.split(delimiter);

                // Iterate through values to get data to create a street object.
                for (int i = 0; i < values.length; i++) {

                    // Use i to determine what kind of data is coming in.
                    switch (i) {
                        case 0:
                            streetID = Integer.parseInt(values[i]);
                            break;
                        case 1:
                            city = values[i];
                            break;
                        case 2:
                            cityPopulation = Integer.parseInt(values[i]);
                            break;
                        case 3:
                            streetName = values[i];
                            break;
                        case 4:
                            carsTraveledDaily = Integer.parseInt(values[i]);
                            break;
                        case 5:
                            speedLimit = Integer.parseInt(values[i]);
                            break;
                    }
                }

                // Create a street object.
                Street newStreet = new Street(streetID, city, cityPopulation, streetName,
                        carsTraveledDaily,  speedLimit);

                // Add the street to the array list.
                theAL.add(newStreet);
            }

        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }

    } // End of loadCSV method.

    // This method loads the data from the JSON file.
    public static void loadJSON(ArrayList<Street> theAL) throws IOException {

        // Instantiate a new ObjectMapper.
        final ObjectMapper mapper = new ObjectMapper();

        // Initialize a new file.
        final File JSON_FILE = new File("city_street_traffic_50000.json");

        // Create a json node.
        JsonNode root = mapper.readTree(JSON_FILE);

        // Parse values and create street obejcts.
        for (JsonNode jn : root) {

            // Parse data from the json file.
            streetID = jn.path("street_id").asInt();
            city = jn.path("city").asText();
            cityPopulation = jn.path("city_population").asInt();
            streetName = jn.path("street_name").asText();
            carsTraveledDaily = jn.path("cars_traveled_daily").asInt();
            speedLimit = jn.path("speed_limit_mph").asInt();

            // Create a new Street object.
            Street newStreet = new Street(streetID, city, cityPopulation, streetName, carsTraveledDaily, speedLimit);

            // Add the new Street to the arraylist.
            theAL.add(newStreet);
        }
    }
}
