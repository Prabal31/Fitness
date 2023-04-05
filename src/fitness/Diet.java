package fitness;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Diet {

    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");

    Image background = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");

    ImageView Logo = new ImageView(logo);

    DietData data = new DietData();

    public ArrayList<String> foodList = new ArrayList<>();

    public void type(String key) {
        Stage type = new Stage();
        GridPane root = new GridPane();

        root.setHgap(10); // Set horizontal gap between buttons
        root.setVgap(10);

        root.setAlignment(Pos.TOP_CENTER);
        type.getIcons().add(logo);

        BackgroundImage view = new BackgroundImage(background,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(type.getWidth(), type.getHeight(), false, false, false, true));
        root.setBackground(new Background(view));

        Logo.setFitWidth(100);
        Logo.setFitHeight(100);

        HBox Logobox = new HBox();
        Logobox.getChildren().add(Logo);

        Logobox.setAlignment(Pos.CENTER);
        root.add(Logobox, 0, 0, 2, 1);

        Logobox.setAlignment(Pos.CENTER);

        GridPane.setValignment(Logobox, VPos.TOP);

        HBox goalbox = new HBox();
        Label setyourgoallabel = new Label("Select your plan");

        setyourgoallabel.setFont(Font.font(24));
        goalbox.setAlignment(Pos.CENTER);

        setyourgoallabel.setTextFill(Color.AQUA);
        goalbox.getChildren().add(setyourgoallabel);

        root.add(goalbox, 0, 3, 2, 1);

        ImageView veganimage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\vegan.png"));
        ImageView vegimage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\veg.png"));
        ImageView nonvegimage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\non-veg.png"));

        veganimage.setFitWidth(100);
        veganimage.setFitHeight(100);

        vegimage.setFitWidth(100);
        vegimage.setFitHeight(100);

        nonvegimage.setFitWidth(100);
        nonvegimage.setFitHeight(100);

        HBox images = new HBox(40);
        images.setAlignment(Pos.CENTER);
        images.getChildren().addAll(veganimage, vegimage, nonvegimage);

        root.add(images, 0, 8, 2, 1);

        HBox button = new HBox(80);
        Button veganButton = new Button("Vegan");
        veganButton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");

        Button vegetarianButton = new Button("Vegetarian");
        vegetarianButton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");

        Button nonVegetarianButton = new Button("Non-\nVegetarian");
        nonVegetarianButton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");

        button.getChildren().addAll(veganButton, vegetarianButton, nonVegetarianButton);

        button.setAlignment(Pos.CENTER);
        root.add(button, 0, 10, 2, 1);

        HBox backbox = new HBox();

        Button backButton = new Button("Back To Home Page");
        backButton.setStyle("-fx-background-color:#000; -fx-text-fill:white;");

        backbox.getChildren().add(backButton);
        backbox.setAlignment(Pos.CENTER);
        root.add(backbox, 0, 20, 2, 1);

        veganButton.setOnAction(e -> {
            openVegan(key,type);
            
        });
        vegetarianButton.setOnAction(e -> openVegetarian());
        nonVegetarianButton.setOnAction(e -> openNonVegetarian());

        Scene scene = new Scene(root, 400, 550);
        type.setScene(scene);
        type.show();
    }

    public void openVegan(String key,Stage type) {
        foodList.add("Tofu");
        foodList.add("Lentils");
        foodList.add("Quinoa");
        foodList.add("Barley");
        foodList.add("Leafy Greens");
        foodList.add("Kidney Beans");
        foodList.add("Apples");
        foodList.add("Banana");
        foodList.add("Almond Milk");
        foodList.add("Oat Milk");
        foodList.add("Chia Seeds");
        foodList.add("Black Beans");
        // handle opening vegan menu

        data.vegan(foodList, key);
        type.close();
    }

    private void openVegetarian() {
        // handle opening vegetarian menu
    }

    private void openNonVegetarian() {
        // handle opening non-vegetarian menu
    }

}
