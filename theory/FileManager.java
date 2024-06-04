/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.theory;

/**
 *
 * @author Dell
 */
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String USERS_FILE = "users.txt";
    private static final String FLIGHTS_FILE = "flights.txt";
    private static final String ADMINS_FILE = "admins.txt";

    public static void saveUser(User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE, true))) {
            writer.println(user.getName() + "," + user.getUserID() + "," + user.getPhoneNumber() + "," + user.getEmail() + "," +
                    user.getPassword() + "," + user.getCity() + "," + user.getCountry());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFlight(Flight flight) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FLIGHTS_FILE, true))) {
            writer.println(flight.getFlightNumber() + "," + flight.getDeparture() + "," + flight.getDestination() + "," +
                    flight.getDepartureTime() + "," + flight.getArrivalTime() + "," + flight.getCapacity() + "," + flight.getBookedSeats());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                users.add(new User(data[0], Integer.parseInt(data[1]), data[2], data[3], data[4], data[5], data[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Flight> loadFlights() {
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

    public static ArrayList<Admin> loadAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMINS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                admins.add(new Admin(data[0], Integer.parseInt(data[1]), data[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admins;
    }

    public static void saveAdmin(Admin newAdmin) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ADMINS_FILE, true))) {
            writer.println(newAdmin.getName() + "," + newAdmin.getAdminID() + "," + newAdmin.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Flight getFlightByNumber(String flightNumber) {
        ArrayList<Flight> flights = loadFlights();
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public static boolean cancelFlight(String flightNumber) {
        ArrayList<Flight> flights = loadFlights();
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flights.remove(flight);
                // Rewrite all flights to file after removing
                try (PrintWriter writer = new PrintWriter(new FileWriter(FLIGHTS_FILE))) {
                    for (Flight f : flights) {
                        writer.println(f.getFlightNumber() + "," + f.getDeparture() + "," + f.getDestination() + "," +
                                f.getDepartureTime() + "," + f.getArrivalTime() + "," + f.getCapacity() + "," + f.getBookedSeats());
                    }
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false; // Flight not found
    }
}
