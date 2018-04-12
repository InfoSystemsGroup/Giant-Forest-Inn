package hotel.main;

import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Currency;

public class Rooms {

    private SimpleStringProperty Number;
    private SimpleStringProperty Category;
    private SimpleStringProperty Type;
    private SimpleStringProperty Location;
    private SimpleStringProperty Sleeps;
    private SimpleIntegerProperty Price;
    private SimpleStringProperty Status;
    private JFXCheckBox Select;

    public Rooms(String Number, String Category, String Type, String Location, String Sleeps, int Price) {

        this.Select = new JFXCheckBox();
        this.Number = new SimpleStringProperty(Number);
        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Sleeps = new SimpleStringProperty(Sleeps);
        this.Price = new SimpleIntegerProperty(Price);
    }

    public Rooms(String Number, String Category, String Type, String Location, String Status) {

        this.Number = new SimpleStringProperty(Number);
        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Status = new SimpleStringProperty(Status);
    }

    public Rooms(String Number, String Status) {

        this.Status = new SimpleStringProperty(Status);
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

    public String getStatus() {
        return Status.get();
    }

    public void setStatus(String Status) {
        this.Status.set(Status);
    }

    public JFXCheckBox getSelect() {
        return Select;
    }

    public void setSelect(JFXCheckBox Select) {
        this.Select = Select;
    }
}