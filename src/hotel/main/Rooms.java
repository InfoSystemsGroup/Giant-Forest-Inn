package hotel.main;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import hotel.controllers.secondary.DashboardController;
import hotel.queries.RoomStatusQueries;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Rooms {

    private SimpleIntegerProperty Number;
    private SimpleStringProperty Category;
    private SimpleStringProperty Type;
    private SimpleStringProperty Location;
    private SimpleStringProperty Sleeps;
    private SimpleIntegerProperty Price;
    private SimpleStringProperty Condition;
    private JFXCheckBox Select;
    private JFXComboBox Status;
    private Color green = Color.valueOf("028444");

    public Rooms(int Number, String Category, String Type, String Location, String Sleeps, int Price) {

        this.Select = new JFXCheckBox();
        this.Number = new SimpleIntegerProperty(Number);
        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Sleeps = new SimpleStringProperty(Sleeps);
        this.Price = new SimpleIntegerProperty(Price);
    }

    public Rooms(int Number, String Category, String Type, String Location, String Condition) {

        this.Number = new SimpleIntegerProperty(Number);
        this.Category = new SimpleStringProperty(Category);
        this.Type = new SimpleStringProperty(Type);
        this.Location = new SimpleStringProperty(Location);
        this.Status = new JFXComboBox();
        final ObservableList<String> Status = FXCollections.observableArrayList("Clean", "Dirty", "Needs Repair");
        this.Status.setItems(Status);
        this.Status.getSelectionModel().select(Condition);
        this.Status.setFocusColor(green);
        this.Status.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

                    switch (newValue.toString()) {
                        case "Clean":
                            try {
                                new RoomStatusQueries().updateDatabase("Clean", this.Number.getValue());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Dirty":
                            try {
                                new RoomStatusQueries().updateDatabase("Dirty", this.Number.getValue());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case "Needs Repair":
                            try {
                                new RoomStatusQueries().updateDatabase("Needs Repair", this.Number.getValue());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                });
    }

    public int getNumber() {
        return Number.get();
    }

    public void setNumber(int Number) {
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