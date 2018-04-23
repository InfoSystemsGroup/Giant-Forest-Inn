package hotel.queries;

import hotel.controllers.secondary.DashboardController;
import hotel.main.Bookings;
import hotel.main.Rooms;
import javafx.scene.chart.PieChart;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.valueOf;

public class DashboardQueries extends DashboardController {

    private Statement statement;
    private Connection connection;

    private LocalDate currentDate = LocalDate.now();

    // Method handles database connection
    private static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        return DriverManager.getConnection("jdbc:ucanaccess://C:/IntelliJ Projects/Giant-Forest-Inn/Dependencies/Database/giantForestInn.accdb");
    }

    public void loadTable() throws Exception {

        connection = getConnection();

        try {
            PreparedStatement statusTable = connection.prepareStatement("SELECT bookingsID.roomID, personID.firstName, personID.lastName, bookingsID.checkIn, bookingsID.checkOut\n" +
                    "FROM personID INNER JOIN bookingsID ON personID.[personID] = bookingsID.[personID];");

            ResultSet rs = statusTable.executeQuery();

            while (rs.next()) {

                bookings.add(new Bookings(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("roomID"),
                        rs.getDate("checkIn"),
                        rs.getDate("checkOut")
                ));
            }

            connection.close();
        }

        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void loadPieChart() throws Exception {

        connection = getConnection();

        try {
            PreparedStatement statusTable = connection.prepareStatement("SELECT roomID, roomStatus FROM roomsID;");

            ResultSet rs = statusTable.executeQuery();

            while (rs.next()) {

                status.add(rs.getString("roomStatus"));
                amount.add(rs.getInt("roomID"));
            }

            for (int i = 0; i < amount.size(); i++) {

                if (status.get(i).equals("Clean"))
                    clean.add(amount.get(i));
                if (status.get(i).equals("Dirty"))
                    dirty.add(amount.get(i));
                if (status.get(i).equals("Needs Repair"))
                    needsRepair.add(amount.get(i));
            }

            rooms.add(new PieChart.Data("Clean", clean.size()));
            rooms.add(new PieChart.Data("Dirty", dirty.size()));
            rooms.add(new PieChart.Data("Needs Repair", needsRepair.size()));

            connection.close();
        }

        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public int getAvailableRooms() throws Exception {

        connection = getConnection();

        try {
            PreparedStatement availability = connection.prepareStatement("SELECT roomID, checkIn, checkOut FROM bookingsID;");
            PreparedStatement totalRooms = connection.prepareStatement("SELECT roomID FROM roomsID;");

            ResultSet rs = availability.executeQuery();
            ResultSet tr = totalRooms.executeQuery();

            while (rs.next()) {

                checkInDate.add(rs.getDate("checkIn"));
                checkOutDate.add(rs.getDate("checkOut"));
            }

            for (int i = 0; i < checkInDate.size(); i++) {

                if (checkInDate.get(i).toLocalDate().isEqual(currentDate) || checkOutDate.get(i).toLocalDate().isEqual(currentDate) || (checkInDate.get(i).toLocalDate().isBefore(currentDate) && checkOutDate.get(i).toLocalDate().isAfter(currentDate)))
                    available.add(checkInDate.size());
            }

            while (tr.next()) {

                totalAvailable.add(tr.getInt("roomID"));
            }

            connection.close();
        }

        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        return totalAvailable.size() - available.size();
    }

    public int getGuests() throws Exception {

        connection = getConnection();

        try {
            PreparedStatement guest = connection.prepareStatement("SELECT personID FROM personID;");

            ResultSet rs = guest.executeQuery();

            while (rs.next()) {

                totalGuests.add(rs.getInt("personID"));
            }

            connection.close();
        }

        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return totalGuests.size();
    }
}
