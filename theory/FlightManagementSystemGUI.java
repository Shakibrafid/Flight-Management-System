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

public class FlightManagementSystemGUI extends JFrame implements ActionListener {
    private JButton userLoginButton, userSignupButton, adminLoginButton, adminSignupButton;

    public FlightManagementSystemGUI() {
        setTitle("Flight Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        userLoginButton = new JButton("User Login");
        userSignupButton = new JButton("User Signup");
        adminLoginButton = new JButton("Admin Login");
        adminSignupButton = new JButton("Admin Signup");

        userLoginButton.addActionListener(this);
        userSignupButton.addActionListener(this);
        adminLoginButton.addActionListener(this);
        adminSignupButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(userLoginButton);
        panel.add(userSignupButton);
        panel.add(adminLoginButton);
        panel.add(adminSignupButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userLoginButton) {
            new UserLoginGUI();
        } else if (e.getSource() == userSignupButton) {
            new UserRegistrationGUI();
        } else if (e.getSource() == adminLoginButton) {
            // Assuming AdminLoginGUI is implemented similarly
            new AdminLoginGUI();
        } else if (e.getSource() == adminSignupButton) {
            // Assuming AdminRegistrationGUI is implemented similarly
            new AdminRegistrationGUI();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FlightManagementSystemGUI::new);
    }
}

