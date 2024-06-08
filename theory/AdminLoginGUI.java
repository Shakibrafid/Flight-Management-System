
package project.theory;


import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminLoginGUI extends JFrame implements ActionListener {
    private JTextField adminIDField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // ArrayList to hold admin data
    private ArrayList<Admin> admins;

    public AdminLoginGUI() {
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel adminIDLabel = new JLabel("Admin ID:");
        JLabel passwordLabel = new JLabel("Password:");

        adminIDField = new JTextField(10);
        passwordField = new JPasswordField(10);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(adminIDLabel);
        panel.add(adminIDField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);

        // Load admin data from file
        admins = FileManager.loadAdmins();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            int adminID = Integer.parseInt(adminIDField.getText());
            String password = new String(passwordField.getPassword());

            boolean adminExists = false;
            for (Admin admin : admins) {
                if (admin.getAdminID() == adminID) {
                    adminExists = true;
                    // Check if the entered password matches the stored password
                    if (admin.getPassword().equals(password)) {
                        JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + admin.getName());
                        // Perform actions after successful login (e.g., open admin dashboard)
                        // Example: new AdminDashboard(admin);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // If admin ID does not exist
            if (!adminExists) {
                JOptionPane.showMessageDialog(this, "Admin ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


