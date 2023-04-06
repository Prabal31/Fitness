package fitness;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class ExerciseGUI extends Application {
    private RadioButton beginnerBox;
    private RadioButton intermediateBox;
    private RadioButton advancedBox;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exercise");

        BorderPane windowPane = new BorderPane();
        windowPane.setPadding(new Insets(10));

        GridPane centerPane = new GridPane();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setVgap(10);

        beginnerBox = new RadioButton("Beginner");
        intermediateBox = new RadioButton("Intermediate");
        advancedBox = new RadioButton("Advanced");

        ToggleGroup radioGroup = new ToggleGroup();
        beginnerBox.setToggleGroup(radioGroup);
        intermediateBox.setToggleGroup(radioGroup);
        advancedBox.setToggleGroup(radioGroup);

        centerPane.add(new Label("Select your exercise level:"), 0, 0);
        centerPane.add(beginnerBox, 0, 1);
        centerPane.add(intermediateBox, 0, 2);
        centerPane.add(advancedBox, 0, 3);

        HBox southPane = new HBox();
        southPane.setAlignment(Pos.CENTER_RIGHT);

        Button nextButton = new Button("Next");
        nextButton.setOnAction(event -> {
            saveToFile();
            createTimeGUI();
        });
        southPane.getChildren().add(nextButton);

        windowPane.setCenter(centerPane);
        windowPane.setBottom(southPane);

        Scene scene = new Scene(windowPane, 400, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("exercise.txt"));
            if (beginnerBox.isSelected()) {
                writer.write("Beginner");
                writer.newLine();
            }
            if (intermediateBox.isSelected()) {
                writer.write("Intermediate");
                writer.newLine();
            }
            if (advancedBox.isSelected()) {
                writer.write("Advanced");
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void createTimeGUI() {
        Stage squatsStage = new Stage();
        squatsStage.setTitle("Squats");

        RadioButton bo1 = new RadioButton("10");
        RadioButton bo2 = new RadioButton("20");
        RadioButton bo3 = new RadioButton("30");

        Button nextButton = new Button("Next");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                saveToFile2(bo1, bo2, bo3);
                squatsStage.close();
            }
        });

        Label selectLabel = new Label("Select your number of squats:");
        VBox centerPane = new VBox(10, selectLabel, bo1, bo2, bo3);
        centerPane.setAlignment(Pos.CENTER);

        VBox southPane = new VBox(10, nextButton);
        southPane.setAlignment(Pos.CENTER);

        BorderPane windowPane = new BorderPane();
        windowPane.setPadding(new Insets(10));
        windowPane.setCenter(centerPane);
        windowPane.setBottom(southPane);

        Scene squatsScene = new Scene(windowPane, 400, 550);
        squatsStage.setScene(squatsScene);
        squatsStage.show();
    }

    private void saveToFile2(RadioButton bo1, RadioButton bo2, RadioButton bo3) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("exercise.txt", true));
            if (bo1.isSelected()) {
                writer.write("10");
                writer.newLine();
            }
            if (bo2.isSelected()) {
                writer.write("20");
                writer.newLine();
            }
            if (bo3.isSelected()) {
                writer.write("30");
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
             ex.printStackTrace();
        }
    }
    
    private void createDurationGUI() {
        Stage durationStage = new Stage();
        durationStage.setTitle("Exercise Duration");

        ComboBox<String> durationBox = new ComboBox<>();
        durationBox.getItems().addAll("10 seconds", "20 seconds", "30 seconds", "40 seconds");

        Button nextButton = new Button("Next");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                saveToFile3(durationBox.getValue());
                durationStage.close();
            }
        });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(20);
        vbox.getChildren().add(new Label("Select your exercise duration:"));
        vbox.getChildren().add(durationBox);
        vbox.getChildren().add(nextButton);

        Scene scene = new Scene(vbox, 400, 550);
        durationStage.setScene(scene);
        durationStage.show();
    }

    private void saveToFile3(String duration) {
        try {
            FileWriter fileWriter = new FileWriter("exercise.txt", true);
            fileWriter.write(duration + "\n");
            fileWriter.close();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

