package hotel.main;

import javafx.beans.property.SimpleStringProperty;

public class Rooms {

    private SimpleStringProperty Category;
    private SimpleStringProperty Type;
    private SimpleStringProperty Location;
    private SimpleStringProperty Sleeps;
    private SimpleStringProperty Available;
    private SimpleStringProperty Price;

    public Rooms(String Category, String Type, String Location, String Sleeps, String Available, String Price) {

        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Sleeps = new SimpleStringProperty(Sleeps);
        this.Available = new SimpleStringProperty(Available);
        this.Price = new SimpleStringProperty(Price);
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

    public String getAvailable() {
        return Available.get();
    }

    public void setAvailable(String Available) {
        this.Available.set(Available);
    }

    public String getPrice() {
        return Price.get();
    }

    public void setPrice(String Price) {
        this.Price.set(Price);
    }
}