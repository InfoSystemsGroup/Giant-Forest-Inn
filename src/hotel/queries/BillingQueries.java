package hotel.queries;

import hotel.controllers.secondary.BillingController;
import hotel.main.Billing;

import javax.swing.*;
import java.sql.*;

public class BillingQueries extends BillingController {

    private Statement statement;
    private Connection connection;


    // Method handles database connection
    private static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        return DriverManager.getConnection("jdbc:ucanaccess://C:/IntelliJ Projects/Giant-Forest-Inn/Dependencies/Database/giantForestInn.accdb");
    }

    public void populateBillingID (String person, int numberOfRooms, long totalNights, int totalDue) throws Exception {

        connection = getConnection();

        try {
            PreparedStatement bill = connection.prepareStatement("INSERT INTO billingID (personID, numberOfRooms, totalNights, totalDue) VALUES (?, ?, ?, ?)");
            bill.setString(1, person);
            bill.setInt(2, numberOfRooms);
            bill.setLong(3, totalNights);
            bill.setInt(4, totalDue);
            bill.executeUpdate();

            connection.close();
        }

        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void getSelection(String firstName, String lastName, int billTotal) throws Exception{

        connection = getConnection();

        try {
            PreparedStatement bill = connection.prepareStatement("SELECT billingID.[personID]\n" +
                    "FROM personID INNER JOIN billingID ON personID.personID = billingID.personID\n" +
                    "WHERE (((personID.firstName) = ?) AND ((personID.lastName) = ?) AND ((billingID.totalDue) = ?));\n");
            bill.setString(1, firstName);
            bill.setString(2, lastName);
            bill.setInt(3, billTotal);

            ResultSet rs = bill.executeQuery();

            while (rs.next()) {

                personID = rs.getInt("personID");
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

    public void generateBill() throws Exception {

        connection = getConnection();

        try {
            PreparedStatement getInfo = connection.prepareStatement("SELECT personID.firstName, personID.lastName, bookingsID.roomID, bookingsID.checkIn, bookingsID.checkOut, billingID.totalNights, billingID.totalDue, personID.personID, roomsID.roomPrice\n" +
                    "FROM roomsID INNER JOIN ((personID INNER JOIN bookingsID ON personID.[personID] = bookingsID.[personID]) INNER JOIN billingID ON personID.[personID] = billingID.[personID]) ON roomsID.roomID = bookingsID.roomID\n" +
                    "WHERE (((personID.personID) = ?));");
            getInfo.setInt(1, personID);

            ResultSet rs = getInfo.executeQuery();

            while (rs.next()) {

                fName.add(rs.getString("firstName"));
                lName.add(rs.getString("lastName"));
                roomNumber.add(rs.getInt("roomID"));
                checkIn.add(rs.getDate("checkIn"));
                checkOut.add(rs.getDate("checkOut"));
                roomCost.add(rs.getInt("roomPrice"));
                totalCost.add(rs.getLong("totalDue"));
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

    public void loadTable() throws Exception {

        connection = getConnection();

        try {
            PreparedStatement statusTable = connection.prepareStatement("SELECT personID.firstName, personID.lastName, billingID.numberOfRooms, billingID.totalNights, billingID.totalDue\n" +
                    "FROM personID INNER JOIN billingID ON personID.[personID] = billingID.[personID];");

            ResultSet rs = statusTable.executeQuery();

            while (rs.next()) {

                data.add(new Billing(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("numberOfRooms"),
                        rs.getInt("totalNights"),
                        rs.getInt("totalDue")
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
}