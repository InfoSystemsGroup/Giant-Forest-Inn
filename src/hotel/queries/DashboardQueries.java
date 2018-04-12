package hotel.queries;

import hotel.controllers.secondary.DashboardController;
import hotel.main.Bookings;
import hotel.main.Rooms;
import javafx.scene.chart.PieChart;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.Integer.valueOf;

public class DashboardQueries extends DashboardController {

    private static ArrayList<String> status = new ArrayList<>();
    private static ArrayList<Integer> amount = new ArrayList<>();
    private static ArrayList<Integer> clean = new ArrayList<>();
    private static ArrayList<Integer> dirty = new ArrayList<>();

    private Statement statement;
    private Connection connection;

    // Method handles database connection
    private static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        return DriverManager.getConnection("jdbc:ucanaccess://C:/IntelliJ Projects/Giant-Forest-Inn/Dependencies/Database/giantForestInn.accdb");
    }

    public void loadTable() throws Exception{

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

    public void loadPieChart() throws Exception{

        connection = getConnection();

        try {
            PreparedStatement statusTable = connection.prepareStatement("SELECT roomID, roomStatus FROM roomsID;");

            ResultSet rs = statusTable.executeQuery();

            while (rs.next()) {

                status.add(rs.getString("roomStatus"));
                amount.add(rs.getInt("roomID"));
            }

            for (int i = 0; i < 48; i++) {

                if (status.get(i).equals("Clean"))
                    clean.add(amount.get(i));
                if (status.get(i).equals("Dirty"))
                    dirty.add(amount.get(i));
            }

            rooms.add(new PieChart.Data("Clean", clean.size()));
            rooms.add(new PieChart.Data("Dirty", dirty.size()));

            connection.close();
        }

        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
