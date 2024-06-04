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
import java.util.ArrayList;

public class UserRegistrationGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField userIDField;
    private JTextField phoneNumberField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField cityField;
    private JTextField countryField;
    private JButton registerButton;

    public UserRegistrationGUI() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        JLabel userIDLabel = new JLabel("User ID:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel cityLabel = new JLabel("City:");
        JLabel countryLabel = new JLabel("Country:");

        nameField = new JTextField(20);
        userIDField = new JTextField(10);
        phoneNumberField = new JTextField(15);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(10);
        cityField = new JTextField(15);
        countryField = new JTextField(15);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(userIDLabel);
        panel.add(userIDField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(cityLabel);
        panel.add(cityField);
        panel.add(countryLabel);
        panel.add(countryField);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = nameField.getText();
            int userID;
            try {
                userID = Integer.parseInt(userIDField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "User ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String phoneNumber = phoneNumberField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String city = cityField.getText();
            String country = countryField.getText();

            if (name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || password.isEmpty() || city.isEmpty() || country.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<User> users = FileManager.loadUsers();
            for (User user : users) {
                if (user.getUserID() == userID) {
                    JOptionPane.showMessageDialog(this, "User ID already exists. Please choose another ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            User newUser = new User(name, userID, phoneNumber, email, password, city, country);
            FileManager.saveUser(newUser); // Changed method name to saveUser
            JOptionPane.showMessageDialog(this, "Registration successful! You can now log in.");
            dispose();
        }
    }
}



