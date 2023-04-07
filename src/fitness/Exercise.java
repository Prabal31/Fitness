package fitness;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Exercise {
    

    Aalert alert=new Aalert();
    
    ExerciseData exercisedata=new ExerciseData();
    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");
    
    ImageView Logo = new ImageView(logo);
    
    ArrayList<String> exercises=new ArrayList<>();
    
    public void level(String key) {
        Stage level =new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        gridPane.setAlignment(Pos.TOP_CENTER);
        level.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(level.getWidth(), level.getHeight(), false, false, false, true));
        gridPane.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        gridPane.add(Logobox, 0, 0,2,1);
        
        Logobox.setAlignment(Pos.CENTER);
        
        GridPane.setValignment(Logobox, VPos.TOP);
        
        HBox goalbox = new HBox();
        Label setyourgoallabel = new Label("Select the level of difficuly");

        setyourgoallabel.setFont(Font.font(24));
        goalbox.setAlignment(Pos.CENTER);

        setyourgoallabel.setTextFill(Color.DIMGREY);
        goalbox.getChildren().add(setyourgoallabel);

        gridPane.add(goalbox, 0,2, 2, 1);

        CheckBox normalCheckBox = new CheckBox("Normal");
        CheckBox intermediateCheckBox = new CheckBox("Intermediate");
        CheckBox advancedCheckBox = new CheckBox("Advanced");
        
         normalCheckBox.setOnAction(e -> {
            if (normalCheckBox.isSelected()) {
                intermediateCheckBox.setSelected(false);
                advancedCheckBox.setSelected(false);
                exercises.clear();
                exercises.add("Normal");
            }
        });

        intermediateCheckBox.setOnAction(e -> {
            if (intermediateCheckBox.isSelected()) {
                normalCheckBox.setSelected(false);
                advancedCheckBox.setSelected(false);
                exercises.clear();
                exercises.add("Intermediate");
            }
        });

        advancedCheckBox.setOnAction(e -> {
            if (advancedCheckBox.isSelected()) {
                normalCheckBox.setSelected(false);
                intermediateCheckBox.setSelected(false);
                exercises.clear();
                exercises.add("Advanced");
                
            }
        });

        VBox vBox = new VBox(10, normalCheckBox, intermediateCheckBox, advancedCheckBox);
        
        
        gridPane.add(vBox, 0, 4,2,1);
        
        HBox buttons=new HBox(70);
        Button levelbutton=new Button("Select your pushup preference");

        buttons.setAlignment(Pos.CENTER);
        levelbutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        buttons.getChildren().addAll(levelbutton);

        gridPane.add(buttons,0,5,2,1);
        
        levelbutton.setOnAction(e-> {
            if (!normalCheckBox.isSelected() && !intermediateCheckBox.isSelected() && !advancedCheckBox.isSelected()) {
                
                alert.alertbox("Please select one");
            } 
            else {
                pushup(key);
                System.out.println(exercises);
                level.close();
            }
        });
        
        

        Scene scene = new Scene(gridPane, 400, 550);
        level.setScene(scene);
        level.show();
    
    }
    public void pushup(String key) {
        
        System.out.println("yes");
        Stage pushup =new Stage();
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        
        grid.setAlignment(Pos.TOP_CENTER);
        pushup.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(pushup.getWidth(), pushup.getHeight(), false, false, false, true));
        grid.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        grid.add(Logobox, 0, 0,2,1);
        
        Logobox.setAlignment(Pos.CENTER);
        
        GridPane.setValignment(Logobox, VPos.TOP);
        
        HBox goalbox = new HBox();
        Label setyourgoallabel = new Label("How many pushup can you do?");

        setyourgoallabel.setFont(Font.font(24));
        goalbox.setAlignment(Pos.CENTER);

        setyourgoallabel.setTextFill(Color.DIMGREY);
        goalbox.getChildren().add(setyourgoallabel);

        grid.add(goalbox, 0,2, 2, 1);

        CheckBox pushup5 = new CheckBox("Less than 5 pushups");
        CheckBox pushup10 = new CheckBox("5 to 10 pushups");
        CheckBox pushup20 = new CheckBox("10 to 20 pushups");
        
         pushup5.setOnAction(e -> {
            if (pushup5.isSelected()) {
                pushup10.setSelected(false);
                pushup20.setSelected(false);
                //exercises.remove(exercises.size() - 1);
                exercises.add("Less than 5 pushups");
            }
        });

        pushup10.setOnAction(e -> {
            if (pushup10.isSelected()) {
                pushup5.setSelected(false);
                pushup20.setSelected(false);
                //exercises.remove(exercises.size() - 1);
                exercises.add("5 to 10 pushups");
            }
        });

        pushup20.setOnAction(e -> {
            if (pushup20.isSelected()) {
                pushup5.setSelected(false);
                pushup10.setSelected(false);
                //exercises.remove(exercises.size() - 1);
                exercises.add("10 to 20 pushups");
            }
        });

        VBox vBox = new VBox(10, pushup5, pushup10, pushup20);
        
        
        grid.add(vBox, 0, 4,2,1);
        
        HBox buttons=new HBox(70);
        Button pushupbutton=new Button("Next");

        buttons.setAlignment(Pos.CENTER);
        pushupbutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        buttons.getChildren().addAll(pushupbutton);

        grid.add(buttons,0,5,2,1);
        
        pushupbutton.setOnAction(e-> {
            if (!pushup5.isSelected() && !pushup10.isSelected() && !pushup20.isSelected()) {

                    alert.alertbox("Please select one");                } 
                else {
                    squads(key);
                    System.out.println(exercises);
                    pushup.close();
                }
            });
        Scene scene = new Scene(grid, 400, 550);
        pushup.setScene(scene);
        pushup.show();
    }
    
    public void squads(String key) {
        
        Stage squads =new Stage();
        GridPane grid = new GridPane();
        
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        
        grid.setAlignment(Pos.TOP_CENTER);
        squads.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(squads.getWidth(), squads.getHeight(), false, false, false, true));
        grid.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        grid.add(Logobox, 0, 0,2,1);
        
        Logobox.setAlignment(Pos.CENTER);
        
        GridPane.setValignment(Logobox, VPos.TOP);
        
        HBox goalbox = new HBox();
        Label setyourgoallabel = new Label("How many squads can you do?");

        setyourgoallabel.setFont(Font.font(24));
        goalbox.setAlignment(Pos.CENTER);

        setyourgoallabel.setTextFill(Color.DIMGREY);
        goalbox.getChildren().add(setyourgoallabel);

        grid.add(goalbox, 0,2, 2, 1);

        CheckBox squads10 = new CheckBox("Less than 10");
        CheckBox squads20 = new CheckBox("10 to 20 squads");
        CheckBox squads30 = new CheckBox("20 to 30 squads");
        
         squads10.setOnAction(e -> {
            if (squads10.isSelected()) {
                squads20.setSelected(false);
                squads30.setSelected(false);
                //exercises.remove(exercises.size() - 1);
                exercises.add("Less than 10");
            }
        });

        squads20.setOnAction(e -> {
            if (squads20.isSelected()) {
                squads10.setSelected(false);
                squads30.setSelected(false);
                //exercises.remove(exercises.size() - 1);
                exercises.add("10 to 20 squads");
            }
        });

        squads30.setOnAction(e -> {
            if (squads30.isSelected()) {
                squads10.setSelected(false);
                squads20.setSelected(false);
                //exercises.remove(exercises.size() - 1);
                exercises.add("20 to 30 squads");
            }
        });

        VBox vBox = new VBox(10, squads10, squads20, squads30);
        
        
        grid.add(vBox, 0, 4,2,1);
        
        HBox buttons=new HBox(70);
        Button pushupbutton=new Button("Next");

        buttons.setAlignment(Pos.CENTER);
        pushupbutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        buttons.getChildren().addAll(pushupbutton);

        grid.add(buttons,0,5,2,1);
        
        pushupbutton.setOnAction(e-> {
            if (!squads10.isSelected() && !squads20.isSelected() && !squads30.isSelected()) {

                    alert.alertbox("Please select one");
                } 
                else {
                    Break(key);
                }
            });
        Scene scene = new Scene(grid, 400, 550);
        squads.setScene(scene);
        squads.show();
    }
   
    
     public void Break(String key) {
        Stage bbreak=new Stage();
        // Create a GridPane layout with some padding
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        
        grid.setAlignment(Pos.TOP_CENTER);
        bbreak.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(bbreak.getWidth(), bbreak.getHeight(), false, false, false, true));
        grid.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        grid.add(Logobox, 0, 0,2,1);
        
        Logobox.setAlignment(Pos.CENTER);
        
        GridPane.setValignment(Logobox, VPos.TOP);
        
        HBox goalbox = new HBox();
        Label setyourgoallabel = new Label("Choose your break time?");

        setyourgoallabel.setFont(Font.font(24));
        goalbox.setAlignment(Pos.CENTER);

        setyourgoallabel.setTextFill(Color.DIMGREY);
        goalbox.getChildren().add(setyourgoallabel);

        grid.add(goalbox, 0,3, 2, 1);
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(10, 20, 30);
        comboBox.setValue(10); // set default value to 10
        comboBox.setPrefSize(200, 10); // set size to match previous slider size
        comboBox.setStyle("-fx-font-size: 30px;");
        grid.add(comboBox, 0, 5, 2, 1);
        
        HBox buttonbox=new HBox(30);
        Button submit=new Button("See your diet plan");
        submit.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        buttonbox.setAlignment(Pos.CENTER);
        buttonbox.getChildren().add(submit);
        grid.add(buttonbox, 0, 9,2,1);
        
        System.out.println(exercises);
        
        comboBox.setOnAction(e-> {
            
            Integer selectedValue = comboBox.getValue();
            exercises.add(Integer.toString(selectedValue));
                  
        });
        System.out.println(exercises);

        
        

        submit.setOnAction(e-> {            
            try { 
                FileInputStream file = new FileInputStream("user_data.txt");
                Scanner scan=new Scanner(file);

                ArrayList<String> updatedLines = new ArrayList<>();

                while (scan.hasNextLine()) {

                    String line = scan.nextLine();

                    String[] parts = line.split(",");
                    String username = parts[1];

                    if(username.equals(key)) {

                        line=line+","+"ExerciseplanStart";
                        
                        for (String item : exercises) {

                             line=line+","+item;
                        }
                    }
                    line=line+","+"ExerciseplanEnd"+",";

                    // Write the updated line back to the fil
                    updatedLines.add(line);

                }

               Files.write(Paths.get("user_data.txt"), updatedLines);
           }
            catch (IOException ex) {

                // Handle the exception here
                ex.printStackTrace();

             }
            
            exercisedata.homeExercise(key);
            bbreak.close();
        });
        

        Scene scene = new Scene(grid, 400, 550);
        bbreak.setScene(scene);
        bbreak.show();
    }
    
}





   
 