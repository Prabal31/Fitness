package fitness;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.paint.Color;
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
    
    int c=0;    
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
                vegan.close();
        });

        // Create Scene
        Scene scene = new Scene(gridPane, 400, 550);

        // Set Scene to Stage
        vegan.setScene(scene);
        vegan.show();
    }

    public void continueAllergy(ArrayList<String> foodList,String key){
        
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
        Stage vegandiet=new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.TOP_CENTER);
        vegandiet.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(vegandiet.getWidth(), vegandiet.getHeight(), false, false, false, true));
        gridPane.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        gridPane.add(Logobox, 0, 0,2,1);
        
        GridPane.setValignment(Logobox, VPos.TOP);

        Label label = new Label("Do you want add or remove any item?");
        label.setFont(new Font("Candara Italic", 18.0));
        gridPane.add(label, 0, 1, 2, 1); // column, row, colspan, rowspan

        // Create Button
        Button saveButton = new Button("Save the diet");
        saveButton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        GridPane.setColumnIndex(saveButton, 1);
        GridPane.setRowIndex(saveButton, 6);

        // Create TextArea
        TextArea tempList = new TextArea();
        tempList.setPrefHeight(326);
        tempList.setPrefWidth(200);
        tempList.setStyle("-fx-border-color: black;");
        GridPane.setColumnIndex(tempList, 0);
        GridPane.setRowIndex(tempList, 3);
        GridPane.setRowSpan(tempList, 3);

        // Create VBox
        VBox vBox = new VBox(10);
        GridPane.setColumnIndex(vBox, 1);
        GridPane.setRowIndex(vBox, 3);

        // Create Label and TextField for adding an item
        Button addItem = new Button("Add an Item to the list");
        TextField addItemTextField = new TextField();
        addItemTextField.setPromptText("Add an Item");
        vBox.getChildren().addAll(addItemTextField,addItem);

        // Create Label and TextField for removing an item
        Button removeItem = new Button("Remove an Item from the list");
        TextField removeItemTextField = new TextField();
        removeItemTextField.setPromptText("Remove an Item");
        vBox.getChildren().addAll( removeItemTextField,removeItem);

        // Add all elements to GridPane
        gridPane.getChildren().addAll(saveButton, tempList, vBox);

        // Set ColumnConstraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        
        gridPane.getColumnConstraints().addAll(column1, column2);
        
        
        addItem.setOnAction(e -> {
            
            String foodItem = addItemTextField.getText();
            if (foodItem.isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter the item name");
                alert.showAndWait();
                
            }
            
            else {
                 if(foodList.contains(foodItem)){
                     
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Item already exist");
                    alert.showAndWait();
                }
                 
                else{
                     
                    foodList.add(foodItem);
                    System.out.println(foodList);
                    c++;
                    
                    String newText = "";
                    for (String item : foodList) {
                        
                        newText += "\u2022 " + item + "\n";
                    }
                    tempList.setText(newText);
                    addItemTextField.clear();
                }
            }
            
                
        });
        

        removeItem.setOnAction(e -> {
            
            String foodItem = removeItemTextField.getText();
            if (foodItem.isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter the item name");
                alert.showAndWait();
            } 
            
            else {
                
                if (foodList.contains(foodItem)) {
                    
                    foodList.remove(foodItem);
                    String newText = "";
                    for (String item : foodList) {
                        
                        newText += "\u2022 " + item + "\n";
                    }
                    tempList.setText(newText);
                    removeItemTextField.clear();
                }
            }
        });
        
        String text = "";
        for (String item : foodList) {
            
            text += "\u2022 " + item + "\n"; // using bullet point unicode character
        }
        tempList.setText(text);

        saveButton.setOnAction(e-> {
            try { 
                FileInputStream file = new FileInputStream("user_data.txt");
                Scanner scan=new Scanner(file);

                ArrayList<String> updatedLines = new ArrayList<>();

                while (scan.hasNextLine()) {

                    String line = scan.nextLine();

                    String[] parts = line.split(",");
                    String username = parts[1];

                    if(username.equals(key)) {

                        for (String item : foodList) {

                             line=line+","+item;
                        }
                    }
                    line=line+","+c;

                    // Write the updated line back to the fil
                    updatedLines.add(line);

                }

               Files.write(Paths.get("user_data.txt"), updatedLines);
           }
            catch (IOException ex) {

                // Handle the exception here
                ex.printStackTrace();

             }
            homediet(key,c);
        });
        

       Scene scene = new Scene(gridPane, 400, 550);
       vegandiet.setScene(scene);
       vegandiet.show();
    }
    
    public void  homediet(String key,int c) {
        
        Stage home=new Stage();
        // Create three TextAreas
        // Create a GridPane to hold the TextAreas and the ButtonBox
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        
        grid.setAlignment(Pos.TOP_CENTER);
        home.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(home.getWidth(), home.getHeight(), false, false, false, true));
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
        Label dietpaln = new Label("Your Diet plan");

        dietpaln.setFont(Font.font(24));
        goalbox.setAlignment(Pos.CENTER);

        dietpaln.setTextFill(Color.DIMGREY);
        goalbox.getChildren().add(dietpaln);

        grid.add(goalbox, 0,2, 2, 1);
        
        HBox textareabox=new HBox();
        TextArea textArea1 = new TextArea();
        TextArea textArea2 = new TextArea();
        TextArea textArea3 = new TextArea();
        TextArea textArea4 = new TextArea();

        textareabox.getChildren().addAll(textArea1,textArea2,textArea3,textArea4);
        grid.add(textareabox, 0, 4,2,1);
        // Create three Buttons
        Label breakfast = new Label("Breakfast");
        Label lunch = new Label("Lunch");
        Label dinner = new Label("Dinner");
        Label other = new Label("Other Items");
        breakfast.setFont(Font.font(14));
        lunch.setFont(Font.font(14));
        dinner.setFont(Font.font(14));
        other.setFont(Font.font(14));



        // Create an HBox to hold the Buttons
        HBox buttonBox = new HBox(40);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(breakfast, lunch, dinner,other);

        grid.add(buttonBox, 0, 6,2,1);

        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File("user_data.txt");
            Scanner scanner = new Scanner(file);
            int lineNum = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String username=parts[1];
                if(key.equals(username)) {
                    for(String item:parts) {
                        lines.add(item);
                    }
                } 
            }
        }
        catch (IOException e) {

            // Handle the exception here
            e.printStackTrace();

         } 
         ArrayList<String> data=new ArrayList<>();
         List<String> specificData = lines.subList(8, lines.size());
         System.out.println(specificData);
         
        ArrayList<String> last = new ArrayList<>(specificData.subList(specificData.size() - c-1, specificData.size()));

         
        for (String item : specificData) {
           if (item.equals("Lentils") || item.equals("Quinoa") || item.equals("Barley") ||
               item.equals("Leafy Greens") || item.equals("Kidney Beans")) {

               textArea1.appendText(item+"\n");
           } else if (item.equals("Apples") || item.equals("Banana") || item.equals("Almond Milk") ||
                      item.equals("Oat Milk") || item.equals("Chia Seeds")) {
               textArea2.appendText(item+"\n");
           } else if (item.equals("Black Beans")) {
               textArea3.appendText(item+"\n");
           }
       }
        for (int i = 0; i < last.size(); i++) {
            try {
                int num = Integer.parseInt(last.get(i));
                // The value at index i is a valid integer, do something with it...
            } 
            catch (NumberFormatException e) {
                // The value at index i is not a valid integer, do something else...
                textArea4.appendText(last.get(i) + "\n");
    }
}
         
        
        // Set up the scene and show the stage
        Scene scene = new Scene(grid, 400, 550);
        home.setScene(scene);
        home.show();
    }
}

        
