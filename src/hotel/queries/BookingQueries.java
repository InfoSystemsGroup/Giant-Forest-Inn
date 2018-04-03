package hotel.queries;

import hotel.controllers.secondary.BookingController;

import javax.swing.*;
import java.sql.*;

public class BookingQueries extends BookingController{

    // Method handles database connection
    private static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        return DriverManager.getConnection("jdbc:ucanaccess://C:/IntelliJ Projects/Giant-Forest-Inn/Dependencies/Database/Giant_Forest_Inn_Db.accdb");
    }

    // Method passes credentials into database and retrieves clearance
    public void loadTable(String User, String Pass) throws Exception {

        Connection connection = getConnection();

        try {
            PreparedStatement table = connection.prepareStatement("SELECT  FROM Users WHERE Username = ? AND Password = ?");
            table.setString(1, User);
            //clearance.setString(2, Pass);

            //ResultSet rs = clearance.executeQuery();

            // (rs.next()) {
               // Clearance = rs.getString("Clearance");
           // }

            connection.close();
        }

        // Detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}
