package hotel.main;

import javafx.beans.property.SimpleStringProperty;

public class Users {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty Clearance;

    public Users(String firstName, String lastName, String Clearance) {

        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.Clearance = new SimpleStringProperty(Clearance);
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

    public String getClearance() {
        return Clearance.get();
    }

    public void setClearance(String Clearance) {
        this.Clearance.set(Clearance);
    }
}
