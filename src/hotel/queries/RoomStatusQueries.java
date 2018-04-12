package hotel.queries;

import hotel.controllers.secondary.RoomStatusController;
import hotel.main.Rooms;

import javax.swing.*;
import java.sql.*;

public class RoomStatusQueries extends RoomStatusController {

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
            PreparedStatement statusTable = connection.prepareStatement("SELECT * FROM roomsID");

            ResultSet rs = statusTable.executeQuery();

            while (rs.next()) {

                data.add(new Rooms(
                        rs.getString("roomID"),
                        rs.getString("roomCategory"),
                        rs.getString("roomType"),
                        rs.getString("roomLocation"),
                        rs.getString("roomStatus")
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