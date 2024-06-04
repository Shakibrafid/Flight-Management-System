package project.theory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserLoginGUI extends JFrame implements ActionListener {
    private JTextField userIDField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public UserLoginGUI() {
        setTitle("User Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JLabel userIDLabel = new JLabel("User ID:");
        JLabel passwordLabel = new JLabel("Password:");

        userIDField = new JTextField(10);
        passwordField = new JPasswordField(10);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(userIDLabel);
        panel.add(userIDField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            int userID;
            try {
                userID = Integer.parseInt(userIDField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "User ID must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String password = new String(passwordField.getPassword());

            ArrayList<User> users = FileManager.loadUsers();
            boolean userExists = false;
            for (User user : users) {
                if (user.getUserID() == userID) {
                    userExists = true;
                    if (user.getPassword().equals(password)) {
                        JOptionPane.showMessageDialog(this, "Login successful! Welcome, " + user.getName());
                        new UserDashboard(user);
                        dispose();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
            if (!userExists) {
                JOptionPane.showMessageDialog(this, "User ID does not exist. Please register first.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
