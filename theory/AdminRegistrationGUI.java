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

public class AdminRegistrationGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField adminIDField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public AdminRegistrationGUI() {
        setTitle("Admin Registration");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        JLabel adminIDLabel = new JLabel("Admin ID:");
        JLabel passwordLabel = new JLabel("Password:");

        nameField = new JTextField(10);
        adminIDField = new JTextField(10);
        passwordField = new JPasswordField(10);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(adminIDLabel);
        panel.add(adminIDField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String name = nameField.getText();
            int adminID;
            try {
                adminID = Integer.parseInt(adminIDField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Admin ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String password = new String(passwordField.getPassword());

            // Assuming Admin and FileManager classes exist and work correctly
            Admin newAdmin = new Admin(name, adminID, password);
            FileManager.saveAdmin(newAdmin);

            JOptionPane.showMessageDialog(this, "Admin registered successfully!");

            nameField.setText("");
            adminIDField.setText("");
            passwordField.setText("");

            this.dispose(); // Close window after registration
        }
    }

   
}
