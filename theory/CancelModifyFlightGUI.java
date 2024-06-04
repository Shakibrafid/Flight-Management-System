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
import project.theory.Admin;
import project.theory.ModifyFlightGUI;
import project.theory.User;

public class CancelModifyFlightGUI extends JFrame implements ActionListener {
    private Admin admin;
    private JTextField flightNumberField;
    private JButton cancelFlightButton;
    private JButton modifyFlightButton;

    public CancelModifyFlightGUI(Admin admin) {
        this.admin = admin;
        setTitle("Cancel or Modify Flight");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberField = new JTextField(10);
        cancelFlightButton = new JButton("Cancel Flight");
        modifyFlightButton = new JButton("Modify Flight");

        cancelFlightButton.addActionListener(this);
        modifyFlightButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(flightNumberLabel);
        panel.add(flightNumberField);
        panel.add(cancelFlightButton);
        panel.add(modifyFlightButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String flightNumber = flightNumberField.getText();

        if (e.getSource() == cancelFlightButton) {
            boolean success = admin.cancelFlight(flightNumber);
            if (success) {
                JOptionPane.showMessageDialog(this, "Flight cancelled successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to cancel flight. Please check the flight number.");
            }
        } else if (e.getSource() == modifyFlightButton) {
            // Open a new ModifyFlightGUI to modify the flight
            ModifyFlightGUI modifyFlightGUI = new ModifyFlightGUI(admin, flightNumber);
            modifyFlightGUI.setVisible(true);
        }
    }
}
