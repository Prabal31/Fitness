package fitness;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Diet {
    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");

    
    ImageView Logo = new ImageView(logo);
    
     protected ArrayList<String> foodList;

    public void type() {
        Stage type=new Stage();
        GridPane root = new GridPane();

        root.setAlignment(Pos.TOP_CENTER);
        
        type.getIcons().add(logo);
        
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(type.getWidth(), type.getHeight(), false, false, false, true));
        root.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        root.add(Logobox, 0, 0,2,1);
        
        Logobox.setAlignment(Pos.CENTER);
        
        GridPane.setValignment(Logobox, VPos.TOP);
        
        ImageView veganimage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\vegan.png"));
        ImageView vegimage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\veg.png"));
        ImageView nonvegimage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\non-veg.png"));
        
        veganimage.setFitWidth(100);
        veganimage.setFitHeight(100);
        
        vegimage.setFitWidth(100);
        vegimage.setFitHeight(100);
        
        nonvegimage.setFitWidth(100);
        nonvegimage.setFitHeight(100);

        HBox button=new HBox(50);
        Button veganButton = new Button("Vegan");

        Button vegetarianButton = new Button("Vegetarian");

        Button nonVegetarianButton = new Button("Non-Vegetarian");
        
        button.getChildren().addAll(veganButton,vegetarianButton,nonVegetarianButton);

        button.setAlignment(Pos.CENTER);
        root.add(button, 0,3,2,1);
        
        veganButton.setOnAction(e -> openVegan());
        vegetarianButton.setOnAction(e -> openVegetarian());
        nonVegetarianButton.setOnAction(e -> openNonVegetarian());




        Scene scene = new Scene(root,400,550);
        type.setScene(scene);
        type.show();
    }

    private void openVegan() {
        // handle opening vegan menu
    }

    private void openVegetarian() {
        // handle opening vegetarian menu
    }

    private void openNonVegetarian() {
        // handle opening non-vegetarian menu
    }

}