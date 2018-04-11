package hotel.queries;

import javax.swing.*;
import java.sql.*;

public class BillingQueries {

    private Statement statement;
    private Connection connection;

    // Method handles database connection
    private static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        return DriverManager.getConnection("jdbc:ucanaccess://C:/IntelliJ Projects/Giant-Forest-Inn/Dependencies/Database/giantForestInn.accdb");
    }

    public void generateBill(String booking, long totalNights, int totalDue) throws Exception{

        connection = getConnection();

        try {
            PreparedStatement bill = connection.prepareStatement("INSERT INTO billingID (bookingID, totalNights, totalDue) VALUES (?, ?, ?)");
            bill.setString(1, booking);
            bill.setLong(2, totalNights);
            bill.setInt(3, totalDue);
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
}
