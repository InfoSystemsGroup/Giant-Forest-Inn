package hotel.main;

import com.jfoenix.controls.JFXRadioButton;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ToggleGroup;

public class Billing {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleIntegerProperty numberOfRooms;
    private SimpleIntegerProperty nightsStayed;
    private SimpleIntegerProperty billTotal;
    private JFXRadioButton Select;
    private ToggleGroup group = new ToggleGroup();

    public Billing(String firstName, String lastName, int numberOfRooms, int nightsStayed, int billTotal) {

        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.numberOfRooms = new SimpleIntegerProperty(numberOfRooms);
        this.nightsStayed = new SimpleIntegerProperty(nightsStayed);
        this.billTotal = new SimpleIntegerProperty(billTotal);
        this.Select = new JFXRadioButton();
        this.Select.setToggleGroup(group);
        this.Select.setOnMousePressed(Select.getOnMousePressed());
        this.Select.setOnMouseReleased(Select.getOnMouseReleased());
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

    public int getNumberOfRooms() {
        return numberOfRooms.get();
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms.set(numberOfRooms);
    }

    public int getNightsStayed() {
        return nightsStayed.get();
    }

    public void setNightsStayed(int nightsStayed) {
        this.nightsStayed.set(nightsStayed);
    }

    public int getBillTotal() {
        return billTotal.get();
    }

    public void setBillTotal(int billTotal) {
        this.billTotal.set(billTotal);
    }

    public JFXRadioButton getSelect() {
        return Select;
    }

    public void setSelect(JFXRadioButton Select) {
        this.Select = Select;
    }
}