package fitness;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class User extends Application {

    TextField fullname = new TextField();

    TextField email = new TextField();

    TextField conformemail = new TextField();

    TextField phonenumber = new TextField();

    PasswordField password = new PasswordField();

    Button submit = new Button("Submit");

    Data data = new Data();

    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");

    Image background = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");

    ImageView Logo = new ImageView(logo);
    Diet diet=new Diet();
    
    DietData d=new DietData();
    
    ArrayList<String> addedlist=new ArrayList<>();
    int c=0;

    public User(ArrayList<String> addedlist) {
        this.addedlist=addedlist;
    }

    public User() {
    }

    @Override
    public void start(Stage window) {

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.TOP_CENTER);

        layout.setVgap(15);
        window.setTitle("Welcome");

        window.getIcons().add(logo);

        // Set the properties of the image view
        BackgroundImage view = new BackgroundImage(background,
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            new BackgroundSize(window.getWidth(), window.getHeight(), false, false, false, true));
        layout.setBackground(new Background(view));

        Logo.setFitWidth(100);
        Logo.setFitHeight(100);

        HBox Logobox = new HBox();
        Logobox.getChildren().add(Logo);

        Logobox.setAlignment(Pos.CENTER);
        layout.add(Logobox, 0, 0, 2, 1);

        HBox headingbox = new HBox();
        Label tracker = new Label("My Fitness Tracker");

        tracker.setFont(Font.font(35));
        headingbox.setAlignment(Pos.TOP_CENTER);

        headingbox.getChildren().add(tracker);
        layout.add(headingbox, 0, 1, 2, 1);

        GridPane.setColumnSpan(headingbox, 2);
        GridPane.setValignment(headingbox, VPos.TOP);

        HBox welcomebox = new HBox();
        Label welcome = new Label("Welcome Back!");

        welcome.setTextFill(Color.WHITE);
        welcome.setFont(Font.font(24));

        welcomebox.setAlignment(Pos.CENTER);
        welcomebox.getChildren().add(welcome);

        layout.add(welcomebox, 0, 2, 2, 1);

        HBox emailBox = new HBox();
        emailBox.setAlignment(Pos.CENTER_RIGHT);
        Label emailLabel = new Label("Email");

        emailLabel.setTextFill(Color.AQUA);
        emailLabel.setFont(Font.font(24));

        TextField emailTextField = new TextField();
        emailTextField.setFont(Font.font(16));

        emailBox.getChildren().addAll(emailLabel, emailTextField);
        layout.add(emailBox, 0, 3, 2, 1);
        emailTextField.setAlignment(Pos.BOTTOM_RIGHT);

        HBox passwordBox = new HBox();
        passwordBox.setAlignment(Pos.CENTER_RIGHT);
        Label passwordLabel = new Label("Password");
        passwordLabel.setTextFill(Color.AQUA);

        passwordLabel.setFont(Font.font(24));
        PasswordField passwordTextField = new PasswordField();

        passwordTextField.setFont(Font.font(16));
        passwordBox.getChildren().addAll(passwordLabel, passwordTextField);

        layout.add(passwordBox, 0, 4, 2, 1);
        passwordTextField.setAlignment(Pos.BOTTOM_RIGHT);

        Button log = new Button("Log in");
        log.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");

        layout.add(log, 1, 5);
        GridPane.setHalignment(log, HPos.RIGHT);

        Line line = new Line();
        line.setStartX(0);

        line.setEndX(300);
        line.setStrokeWidth(2);

        layout.add(line, 0, 7, 2, 1);

        HBox newuserbox = new HBox();
        Label newuserLabel = new Label("New to Activity Fitness?");

        newuserLabel.setFont(Font.font(24));
        newuserbox.setAlignment(Pos.CENTER);

        newuserLabel.setTextFill(Color.AQUA);
        newuserbox.getChildren().add(newuserLabel);

        layout.add(newuserbox, 0, 8, 2, 1);
        Button signin = new Button("Create Account");

        signin.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        layout.add(signin, 0, 9, 2, 1);
        GridPane.setHalignment(signin, HPos.CENTER);

        log.setOnAction(e -> {

            String[] userData = data.loadData();

            if (userData == null) {

                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);

                alert.setContentText("Wrong email or password! please try again");
                alert.showAndWait();
            } else {
                String key = emailTextField.getText();
                String last;
                
                
                try { 
                FileInputStream file = new FileInputStream("user_data.txt");
                Scanner scan=new Scanner(file);

                ArrayList<String> updatedLines = new ArrayList<>();
                String l;
                while (scan.hasNextLine()) {

                    l = scan.nextLine();

                    String[] parts = l.split(",");
                    String username = parts[1];

                    if(username.equals(key)) {
                        
                        c=Integer.parseInt(parts[parts.length-1]);
                    }

                }
           }
            catch (IOException ex) {

                // Handle the exception here
                ex.printStackTrace();

             }
                
                // Proceed with the rest of the application
                data.printcheck(key,c);
                window.close();

            }
        });

        signin.setOnAction(e -> {
            //data.goal();
            //heightweight();
            signup();
            //d.homediet();
            //diet.type();
            window.close();
        });

        Scene scene = new Scene(layout, 400, 550);
        window.setScene(scene);

        window.show();
    }

    public void signup() {

        Stage signStage = new Stage();
        signStage.setTitle("Sign in");

        GridPane pane = new GridPane();

        pane.setVgap(15);
        pane.setAlignment(Pos.TOP_CENTER);

        signStage.getIcons().add(logo);

        BackgroundImage view = new BackgroundImage(background,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                new BackgroundSize(signStage.getWidth(), signStage.getHeight(), false, false, false, true));
        pane.setBackground(new Background(view));

        HBox Logobox = new HBox();
        Logobox.getChildren().add(Logo);

        Logobox.setAlignment(Pos.CENTER);
        pane.add(Logobox, 0, 0, 2, 1);

        GridPane.setValignment(Logobox, VPos.TOP);

        HBox headingbox = new HBox();
        Label tracker = new Label("My Fitness Tracker");

        tracker.setFont(Font.font(35));
        headingbox.setAlignment(Pos.TOP_CENTER);

        headingbox.getChildren().add(tracker);
        pane.add(headingbox, 0, 1, 2, 1);

        GridPane.setColumnSpan(headingbox, 2);
        GridPane.setValignment(headingbox, VPos.TOP);

        HBox welcomebox = new HBox();
        Label welcome = new Label("Fill in the details!");
        welcome.setTextFill(Color.WHITE);

        welcome.setFont(Font.font(24));
        welcomebox.setAlignment(Pos.CENTER);

        welcomebox.getChildren().add(welcome);
        pane.add(welcomebox, 0, 2, 2, 1);

        // Full Name field
        HBox fullnameBox = new HBox();
        fullnameBox.setAlignment(Pos.CENTER_RIGHT);

        Label fullnameLabel = new Label("Full name:");
        fullnameLabel.setTextFill(Color.AQUA);

        fullnameLabel.setFont(Font.font(24));
        TextField fullname = new TextField();

        fullname.setFont(Font.font(16));
        fullnameBox.getChildren().addAll(fullnameLabel, fullname);

        pane.add(fullnameBox, 0, 3, 2, 1);
        fullname.setAlignment(Pos.BOTTOM_RIGHT);

        //Email name field
        HBox emailBox = new HBox();
        emailBox.setAlignment(Pos.CENTER_RIGHT);

        Label emailLabel = new Label("Email:");
        emailLabel.setTextFill(Color.AQUA);

        emailLabel.setFont(Font.font(24));
        TextField email = new TextField();

        email.setFont(Font.font(16));
        emailBox.getChildren().addAll(emailLabel, email);

        pane.add(emailBox, 0, 4, 2, 1);
        email.setAlignment(Pos.BOTTOM_RIGHT);

        HBox conformemailBox = new HBox();
        conformemailBox.setAlignment(Pos.CENTER_RIGHT);

        Label conformemailLabel = new Label("Confirm Email:");
        conformemailLabel.setTextFill(Color.AQUA);

        conformemailLabel.setFont(Font.font(24));
        TextField conformemail = new TextField();

        conformemail.setFont(Font.font(16));
        conformemailBox.getChildren().addAll(conformemailLabel, conformemail);

        pane.add(conformemailBox, 0, 5, 2, 1);
        conformemail.setAlignment(Pos.BOTTOM_RIGHT);

        HBox phonenumberBox = new HBox();
        phonenumberBox.setAlignment(Pos.CENTER_RIGHT);

        Label phonenumberLabel = new Label("Phone Number:");
        phonenumberLabel.setTextFill(Color.AQUA);

        phonenumberLabel.setFont(Font.font(24));
        TextField phonenumber = new TextField();

        phonenumber.setFont(Font.font(16));
        phonenumberBox.getChildren().addAll(phonenumberLabel, phonenumber);

        pane.add(phonenumberBox, 0, 6, 2, 1);
        phonenumber.setAlignment(Pos.BOTTOM_RIGHT);

        HBox passwordBox = new HBox();
        passwordBox.setAlignment(Pos.CENTER_RIGHT);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.AQUA);

        passwordLabel.setFont(Font.font(24));
        PasswordField password = new PasswordField();

        password.setFont(Font.font(16));
        passwordBox.getChildren().addAll(passwordLabel, password);

        pane.add(passwordBox, 0, 7, 2, 1);
        password.setAlignment(Pos.BOTTOM_RIGHT);

        // Sign in button
        HBox buttonBox = new HBox(100);
        Button sign = new Button("Next");

        sign.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");
        Button back = new Button("Back");

        buttonBox.getChildren().addAll(sign, back);
        buttonBox.setAlignment(Pos.CENTER);

        pane.add(buttonBox, 1, 8, 2, 1);
        back.setStyle("-fx-background-color:#4CAF50; -fx-text-fill:white;");

        sign.setOnAction(e -> {

            while (true) {

                String fullName = fullname.getText();
                String emailText = email.getText();

                String conformEmailText = conformemail.getText();
                String phoneNumberText = phonenumber.getText();
                String passwordText = password.getText();

                try {

                    if (fullName == null || fullName.isEmpty()
                            || emailText == null || emailText.isEmpty()
                            || conformEmailText == null || conformEmailText.isEmpty()
                            || phoneNumberText == null || phoneNumberText.isEmpty()
                            || passwordText == null || passwordText.isEmpty()) {

                        throw new Exception("Please fill in all the details.");
                    } else if (EmailChecker(emailText, "user_data.txt")) {

                        throw new Exception("This Email exists Please log in.");

                    } else if (!Valid(emailText)) {

                        throw new Exception("Please enter a valid email address.");
                    } else if (!emailText.equals(conformEmailText)) {

                        throw new Exception("The email addresses you entered do not match.");
                    } else if (!fullName.matches("^[a-zA-Z]*$")) {

                        throw new Exception("Please enter a valid name.");
                    } else if (phoneNumberText.length() != 10 || !phoneNumberText.matches("\\d+")) {

                        throw new Exception("Please enter a 10-digit phone number.");
                    } else if (passwordText.length() < 5) {

                        throw new Exception("Password must be at least 5 characters long.");
                    }

                    // all input is valid
                    data.saveData(fullName, emailText, phoneNumberText, passwordText);
                    //data.print(background,logo,Logo,fullName);

                    data.heightweight(email);
                    signStage.close();

                    return; // exit the method

                } catch (Exception ex) {

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText(null);

                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();

                    break; // exit the loop and wait for user input again
                }
            }
        });

        back.setOnAction(e -> {
            start(signStage);
        });
        // create scene and add pane to it
        Scene scene = new Scene(pane, 400, 550);

        signStage.setScene(scene);
        signStage.show();

    }

    public static boolean Valid(String email) {

        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean EmailChecker(String email, String filePath) {
        boolean emailExists = false;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while ((line = reader.readLine()) != null) {

                if (line.contains(email)) {

                    emailExists = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emailExists;
    }

    public void photo() {

    }

    //main method
    public static void main(String[] args) {

        launch(args);

    }

}
