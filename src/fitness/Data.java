package fitness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Data {
    
    Aalert alert=new Aalert();

    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");

    ImageView Logo = new ImageView(logo);
    
    Diet diett=new Diet();
    DietData data=new DietData();
    
    Exercise exercisee=new Exercise();
    
    ExerciseData edata=new ExerciseData();
    
    boolean matchfound = false;
    
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
            return data.split(",");

        } 
        catch (IOException e) {

            e.printStackTrace();
            return null;

        }
    }
    
    
    public void heightweight(TextField email) {
        
        Stage stage=new Stage();
        GridPane gridPane = new GridPane();
        
        gridPane.setAlignment(Pos.TOP_CENTER);
        
        gridPane.setVgap(15);
        stage.setTitle("Welcome");

        stage.getIcons().add(logo);

        // Set the properties of the image view
        BackgroundImage view = new BackgroundImage(background,
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        new BackgroundSize(stage.getWidth(), stage.getHeight(), false, false, false, true));
        gridPane.setBackground(new Background(view));
        
        Logo.setFitWidth(100);
        Logo.setFitHeight(100);
        
        
        HBox Logobox=new HBox();
        Logobox.getChildren().add(Logo);
        
        Logobox.setAlignment(Pos.CENTER);
        gridPane.add(Logobox, 0, 0,2,1);
        
        Logobox.setAlignment(Pos.CENTER);
        // Create labels for height and weight
        
        HBox Bmibox=new HBox();
        Label bmilabel=new Label("Enter your height and weight");
        
        bmilabel.setFont(Font.font(24));
        Bmibox.setAlignment(Pos.CENTER);
        
        bmilabel.setTextFill(Color.ORANGE);
        Bmibox.getChildren().add(bmilabel);
        
        gridPane.add(Bmibox, 0, 1,2,1);
        
        Label heightLabel = new Label("Height:");
        Label weightLabel = new Label("Weight:");
        
        // Create text fields for entering height and weight
        TextField heightTextField = new TextField();
        TextField weightTextField = new TextField();
        
        // Create a GridPane to contain the labels and text fields
        
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        gridPane.setPadding(new Insets(10));
        
        // Add the labels and text fields to the GridPane
        gridPane.add(heightLabel, 0, 2);
        
        gridPane.add(heightTextField, 1, 2);
        
        gridPane.add(weightLabel, 0, 4);
        gridPane.add(weightTextField, 1, 4);
        
       
        
        // Create a button to calculate the BMI
        Button calculateButton = new Button("Calculate your BMI");
        
        calculateButton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        gridPane.add(calculateButton, 0, 5);

        calculateButton.setOnAction(event -> {
            
            if(heightTextField.getText().isEmpty() || weightTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Error");
                
                alert.setHeaderText("Please fill in the details");
                alert.showAndWait();
            }
            else {
                double height = Double.parseDouble(heightTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                
                double bmi = weight / (height * height);

                // Create an Alert box to display the BMI
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("BMI Calculator");
                
                alert.setHeaderText("Your BMI is:");
                alert.setContentText(String.format("%.2f", bmi));
                
                alert.showAndWait();
                
                try {
                    FileInputStream file = new FileInputStream("user_data.txt");
                    Scanner scan=new Scanner(file);
                    
                    ArrayList<String> updatedLines = new ArrayList<>();

                    
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        
                        String[] parts = line.split(",");
                        String username = parts[1];
                        
                        if (username.equals(email.getText())) {
                            
                            // Add height and weight data for this user
                            String setheight = heightTextField.getText();
                            
                            String setweightt = weightTextField.getText();
                            double setbmi=bmi;
                            line = line + "," + setheight + "," + setweightt+","+setbmi;
                            
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
            }
            
        });
        
        HBox nextbuttonbox =new HBox();
        Button nextbutton=new Button("Set you goal");
        
        nextbuttonbox.setAlignment(Pos.CENTER);
        nextbuttonbox.getChildren().add(nextbutton);
        
        nextbutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        gridPane.add(nextbuttonbox, 0, 6);
        

        nextbutton.setOnAction(e-> {
            
            if(heightTextField.getText().isEmpty() || weightTextField.getText().isEmpty()) {
                alert.alertbox("Please fill in the details");
            }
            
            else {

            goal(email);
            stage.close();
            
            }
        });
        

        
         // Create a scene with the GridPane as the root node
        Scene scene = new Scene(gridPane, 400, 550);
        // Set the stage title and scene, and show the stage
        
        stage.setTitle("Height and Weight Input");
        stage.setScene(scene);
        
        stage.show();
    }
    
    
    
    
    
    public void goal(TextField email) {
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
        slider.setMin(1);
        slider.setMax(3);
        
        slider.setValue(2);

        // Set the tick marks and labels for the slider
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setStyle("-fx-font-size: 30px;");

        
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        
        slider.setSnapToTicks(true);
        

        // Create a layout and add the slider and labels
        
        pane.add(slider, 0, 3,2,1);
        
        try {
            FileInputStream file = new FileInputStream("user_data.txt");
            Scanner scan=new Scanner(file);
            ArrayList<String> updatedLines = new ArrayList<>();


            while (scan.hasNextLine()) {
                
                String line = scan.nextLine();
                String[] parts = line.split(",");
                
                String username = parts[1];
                
                if (username.equals(email.getText())) {
                    
                    // Add height and weight data for this user
                    
                    double difficultlevel=slider.getValue();
                    line = line + "," +difficultlevel;
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
        HBox mainbox=new HBox();
        Button main=new Button("Submit");
        main.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        
        mainbox.getChildren().add(main);
        mainbox.setAlignment(Pos.CENTER);
        
        pane.add(mainbox, 0, 4,2,1);

        String key=email.getText();
        main.setOnAction(e-> {
            
            print(key);
            
        });
        
        // Set the scene and show the stage
        Scene scene = new Scene(pane, 400, 550);
        goal.setScene(scene);
        goal.show();
    }
    
    
    
    public void print(String key) {
        
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
            matchfound=false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] details = line.split(",");
                String name = details[0];
                String email = details[1];
                String phone = details[2];


                if (email.equals(key)) {
                    // display or do something with the person's details
                    // Add labels and text fields to HBox
                    HBox namebox=new HBox();
                    
                    Label nameLabel = new Label("Name:");
                    nameLabel.setFont(Font.font(25));
                    
                    nameLabel.setTextFill(Color.AQUA);
                    nameLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label nameField = new Label(name);
                    nameField.setFont(Font.font(20));
                    nameField.setTextFill(Color.POWDERBLUE);
                    namebox.getChildren().addAll(nameLabel,nameField);
                    
                    grid.add(namebox, 0, 1);
                    
                    
                    
                    HBox emailbox=new HBox();
                    
                    Label emailLabel = new Label("Email:");
                    emailLabel.setFont(Font.font(25));
                    
                    emailLabel.setTextFill(Color.AQUA);
                    emailLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label emailField = new Label(email);
                    emailField.setFont(Font.font(20));
                    emailField.setTextFill(Color.POWDERBLUE);
                    
                    emailbox.getChildren().addAll(emailLabel,emailField);
                    
                    grid.add(emailbox, 0, 2);
                    
                    
                    
                    HBox phonebox=new HBox();
                    
                    Label phoneLabel = new Label("Phone:");
                    phoneLabel.setFont(Font.font(25));
                    
                    phoneLabel.setTextFill(Color.AQUA);
                    phoneLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label phoneField = new Label(phone);
                    phoneField.setFont(Font.font(20));
                    
                    phoneField.setTextFill(Color.POWDERBLUE);
                    phonebox.getChildren().addAll(phoneLabel,phoneField);
                    
                    grid.add(phonebox, 0, 3);
                    
                    matchfound=true;
                    break;
                    
                }
            }
            
            
            
            reader.close();
        } 
        
        catch (IOException e) {
            
            e.printStackTrace();
        }
        if(!matchfound) {
                
                alert.alertbox("Email not found");                
        }
        else {
            ImageView diet = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\diet.png"));
            ImageView exercise = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\exercise.png"));

            diet.setFitWidth(100);
            diet.setFitHeight(100);

            exercise.setFitWidth(100);
            exercise.setFitHeight(100);

            HBox images=new HBox(30);
            images.setAlignment(Pos.CENTER);
            images.getChildren().addAll(diet,exercise);

            grid.add(images, 0, 4,2,1);

            HBox buttons=new HBox(70);
            Button dietbutton=new Button("Diet plan");
            Button exercisebutton=new Button("Exercise plan");

            buttons.setAlignment(Pos.CENTER);
            dietbutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
            exercisebutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
            buttons.getChildren().addAll(dietbutton,exercisebutton);

            grid.add(buttons,0,5,2,1);

            dietbutton.setOnAction(e-> {
                diett.type(key);
                home.close();
            });
            
            exercisebutton.setOnAction(e-> {
                exercisee.level(key);
                home.close();

            });

            Scene scene = new Scene(grid, 400, 550);
            home.setScene(scene);

            home.show();
        }
    }
    
    public void printcheck(String key) {
        
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
            matchfound=false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] details = line.split(",");
                String name = details[0];
                String email = details[1];
                String phone = details[2];


                if (email.equals(key)) {
                    // display or do something with the person's details
                    // Add labels and text fields to HBox
                    HBox namebox=new HBox();
                    
                    Label nameLabel = new Label("Name:");
                    nameLabel.setFont(Font.font(25));
                    
                    nameLabel.setTextFill(Color.AQUA);
                    nameLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label nameField = new Label(name);
                    nameField.setFont(Font.font(20));
                    nameField.setTextFill(Color.POWDERBLUE);
                    namebox.getChildren().addAll(nameLabel,nameField);
                    
                    grid.add(namebox, 0, 1);
                    
                    
                    
                    HBox emailbox=new HBox();
                    
                    Label emailLabel = new Label("Email:");
                    emailLabel.setFont(Font.font(25));
                    
                    emailLabel.setTextFill(Color.AQUA);
                    emailLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label emailField = new Label(email);
                    emailField.setFont(Font.font(20));
                    emailField.setTextFill(Color.POWDERBLUE);
                    
                    emailbox.getChildren().addAll(emailLabel,emailField);
                    
                    grid.add(emailbox, 0, 2);
                    
                    
                    
                    HBox phonebox=new HBox();
                    
                    Label phoneLabel = new Label("Phone:");
                    phoneLabel.setFont(Font.font(25));
                    
                    phoneLabel.setTextFill(Color.AQUA);
                    phoneLabel.setAlignment(Pos.CENTER_RIGHT);
                    
                    Label phoneField = new Label(phone);
                    phoneField.setFont(Font.font(20));
                    
                    phoneField.setTextFill(Color.POWDERBLUE);
                    phonebox.getChildren().addAll(phoneLabel,phoneField);
                    
                    grid.add(phonebox, 0, 3);
                    
                    matchfound=true;
                    break;
                    
                }
            }
            
            
            
            reader.close();
        } 
        
        catch (IOException e) {
            
            e.printStackTrace();
        }
        if(!matchfound) {
                
                alert.alertbox("Email not found");                
        }
        else {
            ImageView diet = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\diet.png"));
            ImageView exercise = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\exercise.png"));

            diet.setFitWidth(100);
            diet.setFitHeight(100);

            exercise.setFitWidth(100);
            exercise.setFitHeight(100);

            HBox images=new HBox(30);
            images.setAlignment(Pos.CENTER);
            images.getChildren().addAll(diet,exercise);

            grid.add(images, 0, 4,2,1);

            HBox buttons=new HBox(70);
            Button dietbutton=new Button("Diet plan");
            Button exercisebutton=new Button("Exercise plan");

            buttons.setAlignment(Pos.CENTER);
            dietbutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
            exercisebutton.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
            buttons.getChildren().addAll(dietbutton,exercisebutton);

            grid.add(buttons,0,5,2,1);

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
            
            
            dietbutton.setOnAction(e-> {
                
                if(lines.contains("DietplanStart")) {
                    data.homediet(key);
                    home.close();
                }
                else {
                    diett.type(key);
                }
            });
            
            exercisebutton.setOnAction(e-> {
                
                if(lines.contains("ExerciseplanStart")) {
                    edata.homeExercise(key);
                    home.close();
                }
                else {
                    exercisee.level(key);
                }
                
                

            });

            Scene scene = new Scene(grid, 400, 550);
            home.setScene(scene);

            home.show();
        }
    }
}
