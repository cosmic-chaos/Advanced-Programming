package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ch.makery.address.util.LocalDateAdapter;

/**
 * Model class for a Assignment.
 *
 */
public class Assignment {

    private final StringProperty name;
    private final StringProperty classs;
    private final DoubleProperty difficulty;
    private final DoubleProperty urgency;
    private final ObjectProperty<LocalDate> date;

    /**
     * Default constructor.
     */
    public Assignment() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Assignment(String name, String classs) {
        this.name = new SimpleStringProperty(name);
        this.classs = new SimpleStringProperty(classs);

        // Some initial dummy data, just for convenient testing.
        this.difficulty = new SimpleDoubleProperty(0);
        this.urgency = new SimpleDoubleProperty(0);
        this.date = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getClasss() {
        return classs.get();
    }

    public void setClass(String classs) {
        this.classs.set(classs);
    }

    public StringProperty classProperty() {
        return classs;
    }

    public double getDifficulty() {
        return difficulty.get();
    }

    public void setDifficulty(double difficulty) {
        this.difficulty.set(difficulty);
    }

    public DoubleProperty difficultyProperty() {
        return difficulty;
    }

    public double getUrgency() {
        return urgency.get();
    }

    public void setUrgency(double urgency) {
        this.urgency.set(urgency);
    }

    public DoubleProperty urgencyProperty() {
        return urgency;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return date;
    }
}