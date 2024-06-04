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

public class AdminDashboard extends JFrame implements ActionListener {
    private JButton addFlightButton;
    private JButton viewFlightsButton;
    private JButton cancelModifyFlightButton;
    private Admin admin;

    public AdminDashboard(Admin admin) {
        this.admin = admin;
        setTitle("Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        addFlightButton = new JButton("Add Flight Schedule and Route Details");
        viewFlightsButton = new JButton("View Flight Schedule and Route Details");
        cancelModifyFlightButton = new JButton("Cancel or Modify Flight Schedule and Route Details");

        addFlightButton.addActionListener(this);
        viewFlightsButton.addActionListener(this);
        cancelModifyFlightButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(addFlightButton);
        panel.add(viewFlightsButton);
        panel.add(cancelModifyFlightButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFlightButton) {
            new AddFlightGUI(admin);
        } else if (e.getSource() == viewFlightsButton) {
            new ViewFlightsGUI(admin);
        } else if (e.getSource() == cancelModifyFlightButton) {
            new CancelModifyFlightGUI(admin);
        }
    }
}
