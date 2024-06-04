/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.theory;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewFlightsGUI extends JFrame {
    private Admin admin;
    private JTable flightsTable;

    public ViewFlightsGUI(Admin admin) {
        
        setTitle("View Flights");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        ArrayList<Flight> flights = FileManager.loadFlights();
        String[] columns = {"Flight Number", "Departure", "Destination", "Departure Time", "Arrival Time", "Capacity", "Booked Seats"};
        String[][] data = new String[flights.size()][7];

        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            data[i][0] = flight.getFlightNumber();
            data[i][1] = flight.getDeparture();
            data[i][2] = flight.getDestination();
            data[i][3] = flight.getDepartureTime();
            data[i][4] = flight.getArrivalTime();
            data[i][5] = String.valueOf(flight.getCapacity());
            data[i][6] = String.valueOf(flight.getBookedSeats());
        }

        flightsTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(flightsTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
