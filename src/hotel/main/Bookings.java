package hotel.main;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Bookings {

    private SimpleStringProperty Number;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty checkIn;
    private SimpleStringProperty checkOut;

    public Bookings(String firstName, String lastName, String Number, Date checkIn, Date checkOut) {

        this.firstName = new SimpleStringProperty(firstName);
        this.Number = new SimpleStringProperty(Number);
        this.lastName = new SimpleStringProperty(lastName);
        this.checkIn = new SimpleStringProperty(String.valueOf(checkIn));
        this.checkOut = new SimpleStringProperty(String.valueOf(checkOut));
    }

    public String getNumber() {
        return Number.get();
    }

    public void setNumber(String Number) {
        this.Number.set(Number);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getCheckIn() {
        return checkIn.get();
    }

    public void setCheckIn(String checkIn) {
        this.checkIn.set(checkIn);
    }

    public String getCheckOut() {
        return checkOut.get();
    }

    public void setCheckOut(String checkOut) {
        this.checkOut.set(checkOut);
    }
}
