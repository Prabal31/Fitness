package fitness;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Exercise {
    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");
    
    ImageView Logo = new ImageView(logo);
    ArrayList<String> addlevel=new ArrayList<>();
    
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
                addlevel.clear();
                addlevel.add("Normal");
            }
        });

        intermediateCheckBox.setOnAction(e -> {
            if (intermediateCheckBox.isSelected()) {
                normalCheckBox.setSelected(false);
                advancedCheckBox.setSelected(false);
                addlevel.clear();
                addlevel.add("Intermediate");
            }
        });

        advancedCheckBox.setOnAction(e -> {
            if (advancedCheckBox.isSelected()) {
                normalCheckBox.setSelected(false);
                intermediateCheckBox.setSelected(false);
                addlevel.clear();
                addlevel.add("Advanced");
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
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter the item name");
                alert.showAndWait();            
            } 
            else {
                pushup(key,addlevel);
                //level.close();
            }
        });
        
        

        Scene scene = new Scene(gridPane, 400, 550);
        level.setScene(scene);
        level.show();
    
    }
    public void pushup(String key,ArrayList<String> addpushup) {
        
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

        CheckBox pushup5 = new CheckBox("Lsee than 5 pushups");
        CheckBox pushup10 = new CheckBox("5 to 10 pushups");
        CheckBox pushup20 = new CheckBox("10 to 20 pushups");
        
         pushup5.setOnAction(e -> {
            if (pushup5.isSelected()) {
                pushup10.setSelected(false);
                pushup20.setSelected(false);
                addpushup.clear();
                addpushup.add("Lsee than 5 pushups");
            }
        });

        pushup10.setOnAction(e -> {
            if (pushup10.isSelected()) {
                pushup5.setSelected(false);
                pushup20.setSelected(false);
                addpushup.clear();
                addpushup.add("5 to 10 pushups");
            }
        });

        pushup20.setOnAction(e -> {
            if (pushup20.isSelected()) {
                pushup5.setSelected(false);
                pushup10.setSelected(false);
                addpushup.clear();
                addpushup.add("10 to 20 pushups");
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

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter the item name");
                    alert.showAndWait();            
                } 
                else {
                    
                }
            });
    }
}


   
 