package hotel;

import controllers.LoginController;

import java.sql.*;

import javax.swing.*;

public class Queries extends LoginController {

    public static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Brandon/Giant-Forest-Inn/Dependencies/Database/Giant_Forest_Inn_Db.accdb");

        return connection;
    }

    public void LoginQuery(String User, String Pass) throws Exception {

        Connection connection = getConnection();

        try {
            PreparedStatement clearance = connection.prepareStatement("SELECT Clearance FROM Users WHERE Username = ? AND Password = ?");
            clearance.setString(1, User);
            clearance.setString(2, Pass);

            ResultSet rs = clearance.executeQuery();

            while (rs.next()) {
                Clearance = rs.getString("Clearance");
            }

            connection.close();
        }

        // detect problems interacting with the database
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    sqlException.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}