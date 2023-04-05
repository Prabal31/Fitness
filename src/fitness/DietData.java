package fitness;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DietData {
    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");
    
    ImageView Logo = new ImageView(logo);
    
    public void vegan(ArrayList<String> foodList) {
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
        CheckBox peanuts = new CheckBox("Peanuts");
        CheckBox treeNuts = new CheckBox("Tree Nuts");
        CheckBox wheat = new CheckBox("Wheat");
        CheckBox eggs = new CheckBox("Eggs");
        CheckBox milk = new CheckBox("Milk");
        CheckBox soy = new CheckBox("Soy");
        CheckBox fish = new CheckBox("Fish");
        CheckBox none = new CheckBox("None of the allergies mentioned");
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
        submit.setOnAction(event -> continueAllergy(foodList));

        // Create Scene
        Scene scene = new Scene(gridPane, 400, 550);

        // Set Scene to Stage
        vegan.setScene(scene);
        vegan.show();
    }

    private void continueAllergy(ArrayList<String> foodList) {
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
        }

        if(wheat.isSelected()){
            if(foodList.contains("Tortilla")){
                foodList.remove("Tortilla");
            }
            if(foodList.contains("Whole Oats")){
                foodList.remove("Whole Oats");
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
    }
}