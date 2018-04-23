package hotel.queries;

import com.jfoenix.controls.JFXButton;
import hotel.controllers.secondary.BookingController;
import hotel.main.Rooms;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class BookingQueries extends BookingController {

    private Statement statement;
    private Connection connection;

    // Method handles database connection
    private static Connection getConnection() throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

        return DriverManager.getConnection("jdbc:ucanaccess://C:/IntelliJ Projects/Giant-Forest-Inn/Dependencies/Database/giantForestInn.accdb");
    }

    // Method passes credentials into database and retrieves clearance
    public void loadTable(LocalDate checkIn, LocalDate checkOut, String roomCategory, String roomType, String roomLocation) throws Exception {

        connection = getConnection();
        statement = connection.createStatement();

        if (Objects.equals(roomCategory, null) || Objects.equals(roomCategory, ""))
            roomCategory = "*";

        if (Objects.equals(roomType, null) || Objects.equals(roomType, ""))
            roomType = "*";

        if (Objects.equals(roomLocation, null) || Objects.equals(roomLocation, ""))
            roomLocation = "*";

        try {

            ResultSet rs = statement.executeQuery("" +
                    "SELECT roomsID.roomID, roomsID.roomCategory, roomsID.roomType, roomsID.roomLocation, roomsID.roomSleeps, roomsID.roomPrice\n" +
                    "FROM roomsID\n" +
                    "WHERE (((roomsID.roomID) Not In (SELECT DISTINCT roomID FROM \n" +
                    " (\n" +
                    "   SELECT   roomsID.roomID, bookingsID.checkIn, bookingsID.checkOut\n" +
                    "   FROM bookingsID, roomsID\n" +
                    "   WHERE\n" +
                    "     bookingsID.roomID = roomsID.roomID \n" +
                    "      And\n" +
                    "   (\n" +
                    "      ((([bookingsID].[checkIn]) Between  " + "#" + checkIn + "#" + " AND " + "#" + checkOut + "#" + "))\n" +
                    "   Or \n" +
                    "     ((([bookingsID].[checkOut]) Between " + "#" + checkIn + "#" + " And " + "#" + checkOut + "#" + "))\n" +
                    "   Or  \n" +
                    "     ((([bookingsID].[checkIn])< " + "#" + checkIn + "#" + ") And (([bookingsID].[CheckOut])>" + "#" + checkOut + "#" + "))\n" +
                    "   )\n" +
                    " )\n" +
                    ")) AND roomCategory Like " + "\'" + roomCategory + "\'" + " AND roomType Like " + "\'" + roomType + "\'" + " AND roomLocation Like " + "\'" + roomLocation + "\'" + ");");

            while (rs.next()) {

                roomID = rs.getString("roomID");
                price = rs.getString("roomPrice");

                data.add(new Rooms(
                        rs.getInt("roomID"),
                        rs.getString("roomCategory"),
                        rs.getString("roomType"),
                        rs.getString("roomLocation"),
                        rs.getString("roomSleeps"),
                        rs.getInt("roomPrice")
                ));
            }

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

    public void selectRooms(String roomNumber, String person, LocalDate checkIn, LocalDate checkOut) throws Exception {

        connection = getConnection();

        try {
            PreparedStatement booking = connection.prepareStatement("INSERT INTO bookingsID (roomID, personID, checkIn, checkOut) VALUES (?, ?, ?, ?);");
            booking.setString(1, roomNumber);
            booking.setString(2, person);
            booking.setDate(3, Date.valueOf(checkIn));
            booking.setDate(4, Date.valueOf(checkOut));
            booking.executeUpdate();

            PreparedStatement getBookingID = connection.prepareStatement("SELECT bookingID FROM bookingsID WHERE personID = ?");
            getBookingID.setString(1, person);

            ResultSet rs = getBookingID.executeQuery();

            while (rs.next()) {

                bookingID = rs.getString("bookingID");
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

    public void userInformation(String firstName, String lastName, String phone, String email, String address, String city, String state, String zipcode) throws Exception {

        connection = getConnection();

        try {
            PreparedStatement person = connection.prepareStatement("INSERT INTO personID (firstName, lastName, Address, City, State, Zipcode, phoneNumber, emailAddress) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            person.setString(1, firstName);
            person.setString(2, lastName);
            person.setString(3, address);
            person.setString(4, city);
            person.setString(5, state);
            person.setString(6, zipcode);
            person.setString(7, phone);
            person.setString(8, email);
            person.executeUpdate();

            PreparedStatement getPersonID = connection.prepareStatement("SELECT personID, firstName, lastName FROM personID WHERE firstName = ? AND lastName = ? AND phoneNumber = ?");
            getPersonID.setString(1, firstName);
            getPersonID.setString(2, lastName);
            getPersonID.setString(3, phone);

            ResultSet rs = getPersonID.executeQuery();

            while (rs.next()) {

               personID = rs.getString("personID");
               fName = rs.getString("firstName");
               lName = rs.getString("lastName");
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

