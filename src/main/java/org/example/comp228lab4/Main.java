package org.example.comp228lab4;

import javafx.application.Application;
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
        BorderPane root = new BorderPane();
        GridPane formGrid = new GridPane();

        // Labels and TextFields
        String[] labels = {"Name:", "Address:", "Province:", "City:", "Postal Code:", "Phone Number:", "Email:"};
        TextField[] fields = {new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField(), new TextField()};
        for (int i = 0; i < labels.length; i++) {
            formGrid.add(new Label(labels[i]), 0, i);
            formGrid.add(fields[i], 1, i);
        }

        // Checkboxes
        CheckBox studentCouncil = new CheckBox("Student Council");
        CheckBox volunteerWork = new CheckBox("Volunteer Work");
        formGrid.add(studentCouncil, 2, 1);
        formGrid.add(volunteerWork, 2, 5);

        // RadioButtons
        RadioButton csRButton = new RadioButton("Computer Science");
        RadioButton businessRButton = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        csRButton.setToggleGroup(majorGroup);
        businessRButton.setToggleGroup(majorGroup);
        HBox radioButtonBox = new HBox(csRButton, businessRButton);
        formGrid.add(radioButtonBox, 2, 0);

        // ComboBox and ListView
        ComboBox<String> coursesBox = new ComboBox<>();
        ListView<String> selectedCoursesList = new ListView<>();
        VBox comboBoxListViewBox = new VBox(coursesBox, selectedCoursesList);
        formGrid.add(comboBoxListViewBox, 3, 0, 1, 8);

        // Buttons and TextArea
        Button displayButton = new Button("Display");
        TextArea textArea = new TextArea();
        VBox bottomBox = new VBox(10, displayButton, textArea);
        root.setBottom(bottomBox);
        root.setCenter(formGrid);

        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}