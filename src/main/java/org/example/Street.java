/*
This class is used to create street
objects. It is used by the ReadJSON and
ReadCSV classes.
 */

package org.example;

public class Street {

    // These are the properties for the Street class.
    int streetID;
    String city;
    int cityPopulation;
    String streetName;
    int carsTraveledDaily;
    int speedLimit; // speed limit is mph.

    // This is the constructor for the Street class.
    public Street(int streetID, String city, int cityPopulation, String streetName, int carsTraveledDaily, int speedLimit) {
        this.streetID = streetID;
        this.city = city;
        this.cityPopulation = cityPopulation;
        this.streetName = streetName;
        this.carsTraveledDaily = carsTraveledDaily;
        this.speedLimit = speedLimit;
    }

    // This method can be used to print a description of the Street.
    public void printStreet() {
        System.out.println("Street Name: " + this.streetName + "\nID: " + this.streetID +
                            "\nCity: " + this.city + "\nSpeed Limit: " + this.speedLimit + "\n");
    }

    // These are the getters and setters for the Street class.
    public int getStreetID() {
        return streetID;
    }

    public void setStreetID(int streetID) {
        this.streetID = streetID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getCarsTraveledDaily() {
        return carsTraveledDaily;
    }

    public void setCarsTraveledDaily(int carsTraveledDaily) {
        this.carsTraveledDaily = carsTraveledDaily;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
}
