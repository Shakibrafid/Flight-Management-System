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

public class MakeBookingGUI extends JFrame implements ActionListener {
    private User user;
    private JTextField flightNumberField;
    private JButton bookButton;

    public MakeBookingGUI(User user) {
        this.user = user;
        setTitle("Make Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberField = new JTextField(10);
        bookButton = new JButton("Book");
        bookButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(flightNumberLabel);
        panel.add(flightNumberField);
        panel.add(bookButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            String flightNumber = flightNumberField.getText();
            Flight flight = FileManager.getFlightByNumber(flightNumber);
            if (flight != null) {
                if (flight.getBookedSeats() < flight.getCapacity()) {
                    flight.setBookedSeats(flight.getBookedSeats() + 1);
                    FileManager.saveFlight(flight);
                    JOptionPane.showMessageDialog(this, "Booking successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Flight is fully booked.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Flight not found. Please enter a valid flight number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
