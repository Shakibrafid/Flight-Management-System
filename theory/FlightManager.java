/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.theory;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
import java.io.*;
import java.util.ArrayList;

public class FlightManager {

    private static final String FLIGHTS_FILE = "flights.txt";

    static ArrayList<Flight> loadFlights() {
        ArrayList<Flight> flights = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FLIGHTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                flights.add(new Flight(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }

    static void saveFlights(ArrayList<Flight> flights) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FLIGHTS_FILE))) {
            for (Flight flight : flights) {
                writer.println(flight.getFlightNumber() + "," + flight.getDeparture() + "," + flight.getDestination() + "," +
                        flight.getDepartureTime() + "," + flight.getArrivalTime() + "," + flight.getCapacity() + "," + flight.getBookedSeats());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
