package hotel.main;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Currency;

public class Rooms {

    private SimpleStringProperty Number;
    private SimpleStringProperty Category;
    private SimpleStringProperty Type;
    private SimpleStringProperty Location;
    private SimpleStringProperty Sleeps;
    private SimpleIntegerProperty Price;
    private SimpleStringProperty Condition;
    private JFXCheckBox Select;
    private JFXComboBox Status;

    public Rooms(String Number, String Category, String Type, String Location, String Sleeps, int Price) {

        this.Select = new JFXCheckBox();
        this.Number = new SimpleStringProperty(Number);
        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Sleeps = new SimpleStringProperty(Sleeps);
        this.Price = new SimpleIntegerProperty(Price);
    }

    public Rooms(String Number, String Category, String Type, String Location, String Condition) {

        this.Number = new SimpleStringProperty(Number);
        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Status = new JFXComboBox();
        final ObservableList<String> Status = FXCollections.observableArrayList("Clean", "Dirty", "Needs Repair");
        this.Status.setItems(Status);
        this.Status.getSelectionModel().select(Condition);
    }

    public String getNumber() {
        return Number.get();
    }

    public void setNumber(String Number) {
        this.Number.set(Number);
    }

    public String getCategory() {
        return Category.get();
    }

    public void setCategory(String Category) {
        this.Category.set(Category);
    }

    public String getType() {
        return Type.get();
    }

    public void setType(String Type) {
        this.Type.set(Type);
    }

    public String getLocation() {
        return Location.get();
    }

    public void setLocation(String Location) {
        this.Location.set(Location);
    }

    public String getSleeps() {
        return Sleeps.get();
    }

    public void setSleeps(String Sleeps) {
        this.Sleeps.set(Sleeps);
    }

    public int getPrice() {
        return Price.get();
    }

    public void setPrice(int Price) {
        this.Price.set(Price);
    }

    public JFXComboBox getStatus() {
        return Status;
    }

    public void setStatus(JFXComboBox Status) {
        this.Status = Status;
    }

    public JFXCheckBox getSelect() {
        return Select;
    }

    public void setSelect(JFXCheckBox Select) {
        this.Select = Select;
    }
}