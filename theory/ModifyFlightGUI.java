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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyFlightGUI extends JFrame implements ActionListener {
    private Admin admin;
    private JTextField flightNumberField;
    private JTextField departureField;
    private JTextField destinationField;
    private JTextField departureTimeField;
    private JTextField arrivalTimeField;
    private JTextField capacityField;
    private JButton saveButton;

    public ModifyFlightGUI(Admin admin, String flightNumber) {
        this.admin = admin;
        setTitle("Modify Flight");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberField = new JTextField(flightNumber, 10);
        flightNumberField.setEditable(false);

        JLabel departureLabel = new JLabel("Departure:");
        departureField = new JTextField(10);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationField = new JTextField(10);

        JLabel departureTimeLabel = new JLabel("Departure Time:");
        departureTimeField = new JTextField(10);

        JLabel arrivalTimeLabel = new JLabel("Arrival Time:");
        arrivalTimeField = new JTextField(10);

        JLabel capacityLabel = new JLabel("Capacity:");
        capacityField = new JTextField(10);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(flightNumberLabel);
        panel.add(flightNumberField);
        panel.add(departureLabel);
        panel.add(departureField);
        panel.add(destinationLabel);
        panel.add(destinationField);
        panel.add(departureTimeLabel);
        panel.add(departureTimeField);
        panel.add(arrivalTimeLabel);
        panel.add(arrivalTimeField);
        panel.add(capacityLabel);
        panel.add(capacityField);
        panel.add(saveButton);
        add(panel);
        setVisible(true);
    }

    ModifyFlightGUI(User user, String flightNumber) {
        // You need to complete this constructor by loading the flight from the flight number
        // and then filling the text fields with the flight details. Here's an example of how you can do it:
        Flight flight = FileManager.getFlightByNumber(flightNumber);
        if (flight != null) {
            setTitle("Modify Flight");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null);

            flightNumberField = new JTextField(flight.getFlightNumber(), 10);
            flightNumberField.setEditable(false);
            departureField = new JTextField(flight.getDeparture(), 10);
            destinationField = new JTextField(flight.getDestination(), 10);
            departureTimeField = new JTextField(flight.getDepartureTime(), 10);
            arrivalTimeField = new JTextField(flight.getArrivalTime(), 10);
            capacityField = new JTextField(String.valueOf(flight.getCapacity()), 10);

            saveButton = new JButton("Save");
            saveButton.addActionListener(this);

            JPanel panel = new JPanel();
            panel.add(new JLabel("Flight Number:"));
            panel.add(flightNumberField);
            panel.add(new JLabel("Departure:"));
            panel.add(departureField);
            panel.add(new JLabel("Destination:"));
            panel.add(destinationField);
            panel.add(new JLabel("Departure Time:"));
            panel.add(departureTimeField);
            panel.add(new JLabel("Arrival Time:"));
            panel.add(arrivalTimeField);
            panel.add(new JLabel("Capacity:"));
            panel.add(capacityField);
            panel.add(saveButton);
            add(panel);
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Flight not found.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String flightNumber = flightNumberField.getText();
            String departure = departureField.getText();
            String destination = destinationField.getText();
            String departureTime = departureTimeField.getText();
            String arrivalTime = arrivalTimeField.getText();
            String capacityText = capacityField.getText();

            if (departure.isEmpty() || destination.isEmpty() || departureTime.isEmpty() || arrivalTime.isEmpty() || capacityText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int capacity;
            try {
                capacity = Integer.parseInt(capacityText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Capacity must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Flight modifiedFlight = new Flight(flightNumber, departure, destination, departureTime, arrivalTime, capacity);
            boolean savedSuccessfully = admin.modifyFlight(modifiedFlight);

            if (savedSuccessfully) {
                JOptionPane.showMessageDialog(this, "Flight details saved successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save flight details. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
