package project.theory;





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserDashboard extends JFrame implements ActionListener {
    private JButton checkFlightsButton;
    private JButton makeBookingButton;
    private JButton viewBookingsButton;
    private JButton cancelBookingButton;
    private User user;

    public UserDashboard(User user) {
        this.user = user;
        setTitle("User Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        checkFlightsButton = new JButton("Check for Available Flights");
        makeBookingButton = new JButton("Make a Booking");
        viewBookingsButton = new JButton("View Bookings");
        cancelBookingButton = new JButton("Cancel or Modify a Booking");

        checkFlightsButton.addActionListener(this);
        makeBookingButton.addActionListener(this);
        viewBookingsButton.addActionListener(this);
        cancelBookingButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(checkFlightsButton);
        panel.add(makeBookingButton);
        panel.add(viewBookingsButton);
        panel.add(cancelBookingButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkFlightsButton) {
            new CheckFlightsGUI(user);
        } else if (e.getSource() == makeBookingButton) {
            new MakeBookingGUI(user);
        } else if (e.getSource() == viewBookingsButton) {
            new ViewBookingsGUI(user);
        } else if (e.getSource() == cancelBookingButton) {
            new CancelModifyBookingGUI(user);
        }
    }

    private static class CancelModifyBookingGUI extends JFrame implements ActionListener {
        private User user;
        private JTextField flightNumberField;
        private JButton cancelFlightButton;
        private JButton modifyFlightButton;

        public CancelModifyBookingGUI(User user) {
            this.user = user;
            setTitle("Cancel or Modify Booking");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(300, 200);
            setLocationRelativeTo(null);

            JLabel flightNumberLabel = new JLabel("Flight Number:");
            flightNumberField = new JTextField(10);
            cancelFlightButton = new JButton("Cancel Flight");
            modifyFlightButton = new JButton("Modify Flight");

            cancelFlightButton.addActionListener(this::cancelFlight);
            modifyFlightButton.addActionListener(this::modifyFlight);

            JPanel panel = new JPanel();
            panel.add(flightNumberLabel);
            panel.add(flightNumberField);
            panel.add(cancelFlightButton);
            panel.add(modifyFlightButton);

            add(panel);
            setVisible(true);
        }

        private void cancelFlight(ActionEvent e) {
            String flightNumber = flightNumberField.getText();
            // Assuming the method to cancel flight is in another class called FileManager
            boolean success = FileManager.cancelFlight(flightNumber);
            if (success) {
                JOptionPane.showMessageDialog(this, "Flight cancelled successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to cancel flight. Please check the flight number.");
            }
        }

        private void modifyFlight(ActionEvent e) {
            String flightNumber = flightNumberField.getText();
            new ModifyFlightGUI(user, flightNumber);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cancelFlightButton) {
                cancelFlight(e);
            } else if (e.getSource() == modifyFlightButton) {
                modifyFlight(e);
            }
        }
      
    }

    private static class ViewBookingsGUI extends JFrame {
        private User user;

        public ViewBookingsGUI(User user) {
            this.user = user;
            setTitle("View Bookings");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null);

            ArrayList<Booking> bookings = user.getBookings();

            String[] columns = {"Booking ID", "Flight Number", "Departure", "Destination", "Departure Time", "Arrival Time"};
            String[][] data = new String[bookings.size()][columns.length];
            for (int i = 0; i < bookings.size(); i++) {
                Booking booking = bookings.get(i);
                data[i][0] = booking.getBookingId();
                data[i][1] = booking.getFlightNumber();
                data[i][2] = booking.getDeparture();
                data[i][3] = booking.getDestination();
                data[i][4] = booking.getDepartureTime();
                data[i][5] = booking.getArrivalTime();
            }

            JTable bookingsTable = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(bookingsTable);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(scrollPane, BorderLayout.CENTER);

            add(panel);
            setVisible(true);
        }
    }
}
