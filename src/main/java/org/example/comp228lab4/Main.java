package org.example.comp228lab4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage stage) {

        stage.setTitle("Student Information");
        GridPane root = new GridPane();

        // Labels and TextFields
        String[] labels = {"Name:", "Address:", "Province:", "City:", "Postal Code:", "Phone Number:", "Email:"};
        TextField[] fields = {new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField()};
        for (int i = 0; i < labels.length; i++) {
            root.add(new Label(labels[i]), 0, i);
            root.add(fields[i], 1, i);
        }

        // Checkboxes
        CheckBox studentCouncil = new CheckBox("Student Council");
        CheckBox volunteerWork = new CheckBox("Volunteer Work");
        root.add(studentCouncil, 2, 1);
        root.add(volunteerWork, 2, 5);

        // RadioButtons
        RadioButton csRButton = new RadioButton("Computer Science");
        RadioButton businessRButton = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        csRButton.setToggleGroup(majorGroup);
        businessRButton.setToggleGroup(majorGroup);
        HBox radioButtonBox = new HBox(csRButton, businessRButton);
        root.add(radioButtonBox, 2, 0);

        // ComboBox and ListView
        ComboBox<String> coursesBox = new ComboBox<>();
        ListView<String> selectedCoursesList = new ListView<>();
        VBox comboBoxListViewBox = new VBox(coursesBox, selectedCoursesList);
        root.add(comboBoxListViewBox, 3, 0, 1, 8);

        // Add event listener to radio buttons
        addRadioButtonListener(majorGroup, csRButton, businessRButton, coursesBox);

        // Buttons and TextArea
        Button displayButton = new Button("Display");
        TextArea textArea = new TextArea();
        root.add(displayButton, 0, 8);
        root.add(textArea, 1, 8, 3, 1);

        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void addRadioButtonListener(ToggleGroup majorGroup, RadioButton csRButton, RadioButton businessRButton, ComboBox<String> coursesBox) {
        majorGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue == csRButton) {
                    populateCoursesBox(coursesBox, "Computer Science");
                } else if (newValue == businessRButton) {
                    populateCoursesBox(coursesBox, "Business");
                }
            }
        });
    }

    private void populateCoursesBox(ComboBox<String> coursesBox, String major) {
        ObservableList<String> courses = FXCollections.observableArrayList();

        switch (major) {
            case "Computer Science":
                courses.addAll("Python", "C#", "Java");
                break;
            case "Business":
                courses.addAll("Business", "Accounting", "Finance");
                break;
            default:
                break;
        }

        coursesBox.setItems(courses);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
