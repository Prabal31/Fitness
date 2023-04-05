package fitness;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DietData {
    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");
    
    ImageView Logo = new ImageView(logo);
    
    CheckBox peanuts;
    CheckBox treeNuts;
    CheckBox wheat;
    CheckBox eggs;
    CheckBox milk;
    CheckBox soy;
    CheckBox fish;
    CheckBox none;
    
    public void vegan(ArrayList<String> foodList,String key) {
        // Create GridPane
        Stage vegan=new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.TOP_CENTER);
        vegan.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(vegan.getWidth(), vegan.getHeight(), false, false, false, true));
        gridPane.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        gridPane.add(Logobox, 0, 0,2,1);
        
        Logobox.setAlignment(Pos.CENTER);
        
        GridPane.setValignment(Logobox, VPos.TOP);
        

        // Create Label
        Label label = new Label("Do you have any allergies?");
        label.setFont(new Font("Candara Italic", 18.0));
        GridPane.setConstraints(label, 0, 1, 2, 1); // column, row, colspan, rowspan

        // Create CheckBoxes
        peanuts = new CheckBox("Peanuts");
        treeNuts = new CheckBox("Tree Nuts");
        wheat = new CheckBox("Wheat");
        eggs = new CheckBox("Eggs");
        milk = new CheckBox("Milk");
        soy = new CheckBox("Soy");
        fish = new CheckBox("Fish");
        none = new CheckBox("None of the allergies mentioned");
        GridPane.setConstraints(peanuts, 0, 2);
        GridPane.setConstraints(treeNuts, 0, 3);
        GridPane.setConstraints(wheat, 0, 4);
        GridPane.setConstraints(eggs, 0, 5);
        GridPane.setConstraints(milk, 0, 6);
        GridPane.setConstraints(soy, 0, 7);
        GridPane.setConstraints(fish, 0, 8);
        GridPane.setConstraints(none, 0, 9, 2, 1);

        // Create Button
        Button submit = new Button("Continue --->");
        GridPane.setConstraints(submit, 1, 10);

        // Add components to GridPane
        gridPane.getChildren().addAll(label, peanuts, treeNuts, wheat, eggs, milk, soy, fish, none, submit);

        // Set event handler for the button
        submit.setOnAction(event -> {
                continueAllergy(foodList,key);            
        });

        // Create Scene
        Scene scene = new Scene(gridPane, 400, 550);

        // Set Scene to Stage
        vegan.setScene(scene);
        vegan.show();
    }

    public void continueAllergy(ArrayList<String> foodList,String key){
        
        Stage cdiet=new Stage();
        
        System.out.println("Button Clicked");
        System.out.println(foodList);

        if(soy.isSelected()){
            if(foodList.contains("Tofu")){
                foodList.remove("Tofu");
            }
        }

        if(peanuts.isSelected()){
            
            if(foodList.contains("Peanuts")){
                foodList.remove("Peanuts");
            }
        }

        if(treeNuts.isSelected()){
            if(foodList.contains("Almonds")){
                foodList.remove("Almonds");
            }
            if(foodList.contains("Cashews")){
                foodList.remove("Cashews");
            }
            if(foodList.contains("Pistachios")){
                foodList.remove("Pistachios");
            }
            if(foodList.contains("Almond Milk")){
                foodList.remove("Almond Milk");
            }
        }

        if(wheat.isSelected()){
            if(foodList.contains("Tortilla")){
                foodList.remove("Tortilla");
            }
            if(foodList.contains("Whole Oats")){
                foodList.remove("Whole Oats");
            }
            if(foodList.contains("Oat Milk")){
                foodList.remove("Oat Milk");
            }
        }

        if(eggs.isSelected()){
            if(foodList.contains("Omellette")){
                foodList.remove("Omellette");
                foodList.remove("Eggs");
                foodList.remove("Pancakes");
                foodList.add("Vegan Pancakes");
            }
        }

        if(milk.isSelected()){
            if(foodList.contains("Milk")){
                foodList.remove("Milk");
            }
            if(foodList.contains("Yoghurt")){
                foodList.remove("Yoghurt");
            }
        }
        
        
        
        // Create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.setAlignment(Pos.TOP_CENTER);
         cdiet.getIcons().add(logo);

         BackgroundImage view = new BackgroundImage(background,
         BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
         new BackgroundSize(cdiet.getWidth(), cdiet.getHeight(), false, false, false, true));
         gridPane.setBackground(new Background(view));

         Logo.setFitWidth(100);
         Logo.setFitHeight(100);

         HBox Logobox=new HBox();
         Logobox.getChildren().add(Logo);

         Logobox.setAlignment(Pos.CENTER);
         gridPane.add(Logobox, 0, 0,2,1);

         Logobox.setAlignment(Pos.CENTER);

         GridPane.setValignment(Logobox, VPos.TOP);


         VBox v1 = new VBox(30);

         // Create Label and TextField for adding an item
        Label addItemLabel = new Label("Add an Item to the list");
        TextField addItemTextField = new TextField();
        addItemTextField.setPromptText("Add an Item");

        v1.getChildren().addAll(addItemLabel,addItemTextField);

        gridPane.add(v1, 0, 1,1,2);

        VBox v2 = new VBox(30);

        // Create Label and TextField for removing an item
        Label removeItemLabel = new Label("Remove an Item from the list");
        TextField removeItemTextField = new TextField();
        removeItemTextField.setPromptText("Remove an Item");

        v2.getChildren().addAll(addItemLabel,addItemTextField);

        gridPane.add(v2, 0,2,1,2);

        // Create TextArea
        TextArea tempList = new TextArea();
        tempList.setPrefHeight(326);
        tempList.setPrefWidth(200);
        tempList.setStyle("-fx-border-color: black;");
        gridPane.add(tempList,0,0,1,5);

        // Set ColumnConstraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(column1, column2);

        // Create Scene and set it to primaryStage


         try { 
             FileInputStream file = new FileInputStream("user_data.txt");
             Scanner scan=new Scanner(file);

            ArrayList<String> updatedLines = new ArrayList<>();

            while (scan.hasNextLine()) {

                String line = scan.nextLine();

                String[] parts = line.split(",");
                String username = parts[1];

                if(username.equals(key)) {

                    line=line+","+foodList+",";
                }

                // Write the updated line back to the fil
                updatedLines.add(line);

            }

            Files.write(Paths.get("user_data.txt"), updatedLines);
        }
        catch (IOException e) {
                    
            // Handle the exception here
            e.printStackTrace();
                    
            }
        
        Scene scene = new Scene(gridPane, 400, 550);
        cdiet.setScene(scene);
        cdiet.show();
    }
}
        
