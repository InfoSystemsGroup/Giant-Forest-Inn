package hotel.main;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Rooms {

    private SimpleStringProperty Number;
    private SimpleStringProperty Category;
    private SimpleStringProperty Type;
    private SimpleStringProperty Location;
    private SimpleStringProperty Sleeps;
    private SimpleStringProperty Price;
    private CheckBox Select;

    public Rooms(String Number, String Category, String Type, String Location, String Sleeps, String Price) {

        this.Number = new SimpleStringProperty(Number);
        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Sleeps = new SimpleStringProperty(Sleeps);
        this.Price = new SimpleStringProperty(Price);
        this.Select = new CheckBox();
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

    public String getPrice() {
        return Price.get();
    }

    public void setPrice(String Price) {
        this.Price.set(Price);
    }

    public CheckBox getSelect() {
        return Select;
    }

    public void setSelect(CheckBox Select) {
        this.Select = Select;
    }
}