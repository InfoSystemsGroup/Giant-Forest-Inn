package hotel.queries;

import hotel.controllers.secondary.BookingController;
import hotel.main.Rooms;

import javax.swing.*;
import java.sql.*;
import java.util.Objects;

public class BookingQueries extends BookingController {

    private String Category2, Type2, Type3, Type4, Type5, Type6, Location2;

    // Method handles database connection
    private static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        return DriverManager.getConnection("jdbc:ucanaccess://C:/IntelliJ Projects/Giant-Forest-Inn/Dependencies/Database/Giant_Forest_Inn_Db.accdb");
    }

    // Method passes credentials into database and retrieves clearance
    public void loadTable(String Category, String Type, String Location) throws Exception {

        Connection connection = getConnection();

        if (Objects.equals(Category, null) || Objects.equals(Category, "")) {
            Category = "Luxury";
            Category2 = "Cottage";
        }

        else if (Objects.equals(Type, null) || Objects.equals(Type, "")) {
            Type = "1 Queen";
            Type2 = "2 Queens";
            Type3 = "2 Room";
            Type4 = "3 Room";
            Type5 = "4 Room";
            Type6 = "Bridal";
        }

        else if (Objects.equals(Location, null) || Objects.equals(Location, ""))
            Location = "Patio";
            Location2 = "Forest";

        System.out.println(Category);

        try {
            PreparedStatement Table = connection.prepareStatement("SELECT RoomNo, Category, Type, Location, Sleeps, Price FROM Rooms WHERE Category = ? OR Category = ? AND Type = ? OR Type = ? OR Type = ? OR Type = ? OR Type = ? OR Type = ? AND Location = ? OR Location = ?");
            Table.setString(1, Category);
            Table.setString(2, Category2);
            Table.setString(3, Type);
            Table.setString(4, Type2);
            Table.setString(5, Type3);
            Table.setString(6, Type4);
            Table.setString(7, Type5);
            Table.setString(8, Type6);
            Table.setString(9, Location);
            Table.setString(10, Location2);
            System.out.println(Location2);

            ResultSet rs = Table.executeQuery();

            while (rs.next()) {
                //while (rs.getString("Available") == "TRUE" && rs.getString("Location") == Category && rs.getString("Type") == Type && rs.getString("Location" ) == Location) {

                    data.add(new Rooms(
                            rs.getString("RoomNo"),
                            rs.getString("Category"),
                            rs.getString("Type"),
                            rs.getString("Location"),
                            rs.getString("Sleeps"),
                            rs.getString("Price")
                    ));
                }
            //}

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
