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
import java.awt.event.*;
import java.util.ArrayList;

public class CheckFlightsGUI extends JFrame implements ActionListener {
    private User user;
    private JTextField departureField;
    private JTextField destinationField;
    private JButton searchButton;

    public CheckFlightsGUI(User user) {
        this.user = user;
        setTitle("Check Flights");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JLabel departureLabel = new JLabel("Departure:");
        JLabel destinationLabel = new JLabel("Destination:");
        departureField = new JTextField(10);
        destinationField = new JTextField(10);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(departureLabel);
        panel.add(departureField);
        panel.add(destinationLabel);
        panel.add(destinationField);
        panel.add(searchButton);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String departure = departureField.getText();
            String destination = destinationField.getText();
            
            // Assuming you have access to a list of Flight objects called flights
            ArrayList<Flight> searchResults = searchFlights(departure, destination);
            
            // Display the search results, probably in a new window or dialog
            if (!searchResults.isEmpty()) {
                displaySearchResults(searchResults);
            } else {
                JOptionPane.showMessageDialog(this, "No flights found for the given departure and destination.", "No Flights", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    // Method to search for flights based on departure and destination
    private ArrayList<Flight> searchFlights(String departure, String destination) {
        ArrayList<Flight> searchResults = new ArrayList<>();
        Iterable<Flight> flights = null;
        // Assuming flights is a list containing all available flights
        for (Flight flight : flights) {
            if (flight.getDeparture().equalsIgnoreCase(departure) && flight.getDestination().equalsIgnoreCase(destination)) {
                searchResults.add(flight);
            }
        }
        return searchResults;
    }
    
    // Method to display the search results
    private void displaySearchResults(ArrayList<Flight> searchResults) {
        StringBuilder message = new StringBuilder("Search Results:\n");
        for (Flight flight : searchResults) {
            message.append("Flight Number: ").append(flight.getFlightNumber()).append("\n")
                   .append("Departure: ").append(flight.getDeparture()).append("\n")
                   .append("Destination: ").append(flight.getDestination()).append("\n")
                   .append("Departure Time: ").append(flight.getDepartureTime()).append("\n")
                   .append("Arrival Time: ").append(flight.getArrivalTime()).append("\n")
                   .append("Capacity: ").append(flight.getCapacity()).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, message.toString(), "Search Results", JOptionPane.INFORMATION_MESSAGE);
    }
}