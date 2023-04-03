package fitness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Data {
    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");

    
    ImageView Logo = new ImageView(logo);
    
    public void saveData(String name, String email, String phone, String password) {
        
        try {
            
            File file = new File("user_data.txt");
            
            FileWriter writer = new FileWriter(file, true); // true to append
            
            writer.write(name + "," + email + "," + phone + "," + password + "\n"); // add a newline character
            writer.close();
        } 
        
        catch (IOException e) {
            
            e.printStackTrace();
            
        }
    }
    
    public String[] loadData() {
        
        try {

            FileReader reader = new FileReader("user_data.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String data = bufferedReader.readLine();
            bufferedReader.close();
            return data.split(",");

        } 
        catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }
    public void print(Image background,Image logo,ImageView Logo,String key) {
        Stage home = new Stage();
        home.setTitle("Data");
        
        GridPane grid=new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        grid.setAlignment(Pos.TOP_CENTER);
        
        home.getIcons().add(logo);

        // Set the properties of the image view
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
        
        GridPane.setValignment(Logobox, VPos.TOP);
        
        Label heading = new Label("Details");
        heading.setAlignment(Pos.CENTER);
        heading.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        // Add fields to HBox

        try {
            BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                String name = details[0];
                String email = details[1];
                String phone = details[2];

                if (name.contains(key) || email.contains(key) || phone.contains(key)) {
                    // display or do something with the person's details
                    // Add labels and text fields to HBox
                    HBox namebox=new HBox();
                    
                    Label nameLabel = new Label("Name:");
                    nameLabel.setFont(Font.font(35));
                    
                    nameLabel.setTextFill(Color.AQUA);
                    nameLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label nameField = new Label(name);
                    nameField.setFont(Font.font(35));
                    nameField.setTextFill(Color.POWDERBLUE);
                    namebox.getChildren().addAll(nameLabel,nameField);
                    
                    grid.add(namebox, 0, 1);
                    
                    
                    
                    HBox emailbox=new HBox();
                    
                    Label emailLabel = new Label("Email:");
                    emailLabel.setFont(Font.font(35));
                    
                    emailLabel.setTextFill(Color.AQUA);
                    emailLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label emailField = new Label(email);
                    emailField.setFont(Font.font(35));
                    emailField.setTextFill(Color.POWDERBLUE);
                    
                    emailbox.getChildren().addAll(emailLabel,emailField);
                    
                    grid.add(emailbox, 0, 2);
                    
                    
                    
                    HBox phonebox=new HBox();
                    
                    Label phoneLabel = new Label("Phone:");
                    phoneLabel.setFont(Font.font(35));
                    
                    phoneLabel.setTextFill(Color.AQUA);
                    phoneLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label phoneField = new Label(phone);
                    phoneField.setFont(Font.font(35));
                    phoneField.setTextFill(Color.POWDERBLUE);
                    
                    phonebox.getChildren().addAll(phoneLabel,phoneField);
                    
                    grid.add(phonebox, 0, 3);

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(grid, 400, 550);
        home.setScene(scene);
        home.show();
    }
    
    
    public void goal() {
        Stage goal =new Stage();
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));
        
        pane.setAlignment(Pos.TOP_CENTER);
        
        goal.getIcons().add(logo);

        // Set the properties of the image view
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(goal.getWidth(), goal.getHeight(), false, false, false, true));
        pane.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        pane.add(Logobox, 0, 0,2,1);
        
        pane.setVgap(20);// set spacing between images;
        pane.setAlignment(Pos.TOP_CENTER); // align images to center
        
        HBox goalbox=new HBox();
        Label setyourgoallabel=new Label("Set your goal");
        
        setyourgoallabel.setFont(Font.font(24));
        goalbox.setAlignment(Pos.CENTER);
        
        setyourgoallabel.setTextFill(Color.AQUA);
        goalbox.getChildren().add(setyourgoallabel);
        
        pane.add(goalbox, 0, 1,2,1);
        
        ImageView startImage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\1.png"));
        ImageView midImage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\2.png"));
        ImageView endImage = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\3.png"));
        
        startImage.setFitWidth(100);
        startImage.setFitHeight(100);
        
        midImage.setFitWidth(100);
        midImage.setFitHeight(100);
        
        endImage.setFitWidth(100);
        endImage.setFitHeight(100);
        
        HBox images=new HBox(30);
        images.getChildren().addAll(startImage,midImage,endImage);
        
        pane.add(images, 0, 2,2,1);
        
        // Create a slider with start, mid, and end values
        Slider slider = new Slider();
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setMin(0);
        slider.setMax(2);
        slider.setValue(1);

        // Set the tick marks and labels for the slider
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setSnapToTicks(true);

        // Create a layout and add the slider and labels
        
        pane.add(slider, 0, 3,2,1);

        // Set the scene and show the stage
        Scene scene = new Scene(pane, 400, 550);
        goal.setScene(scene);
        goal.show();
    }
}
