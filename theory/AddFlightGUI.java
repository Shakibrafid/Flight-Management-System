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

public class AddFlightGUI extends JFrame implements ActionListener {
    private Admin admin;
    private JTextField flightNumberField;
    private JTextField departureField;
    private JTextField destinationField;
    private JTextField departureTimeField;
    private JTextField arrivalTimeField;
    private JTextField capacityField;
    private JButton addButton;

    public AddFlightGUI(Admin admin) {
        this.admin = admin;
        setTitle("Add Flight");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        JLabel departureLabel = new JLabel("Departure:");
        JLabel destinationLabel = new JLabel("Destination:");
        JLabel departureTimeLabel = new JLabel("Departure Time:");
        JLabel arrivalTimeLabel = new JLabel("Arrival Time:");
        JLabel capacityLabel = new JLabel("Capacity:");

        flightNumberField = new JTextField(10);
        departureField = new JTextField(10);
        destinationField = new JTextField(10);
        departureTimeField = new JTextField(10);
        arrivalTimeField = new JTextField(10);
        capacityField = new JTextField(10);

        addButton = new JButton("Add Flight");
        addButton.addActionListener(this);

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
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            
            String flightNumber = flightNumberField.getText();
            String departure = departureField.getText();
            String destination = destinationField.getText();
            String departureTime = departureTimeField.getText();
            String arrivalTime = arrivalTimeField.getText();
            String capacityText = capacityField.getText();

           
            if (flightNumber.isEmpty() || departure.isEmpty() || destination.isEmpty() ||
                departureTime.isEmpty() || arrivalTime.isEmpty() || capacityText.isEmpty()) {
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

          
            Flight newFlight = new Flight(flightNumber, departure, destination, departureTime, arrivalTime, capacity);

       
            FileManager.saveFlight(newFlight);

       
            JOptionPane.showMessageDialog(this, "Flight added successfully!");

            
            flightNumberField.setText("");
            departureField.setText("");
            destinationField.setText("");
            departureTimeField.setText("");
            arrivalTimeField.setText("");
            capacityField.setText("");
        }
    }
}
