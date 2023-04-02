package fitness;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class User extends Application {
    
    TextField fullname=new TextField();
    
    TextField email=new TextField();
    
    TextField conformemail=new TextField();
    
    TextField phonenumber=new TextField();
    
    PasswordField password=new PasswordField();
    
    Button submit=new Button("Submit");
    
    Data data=new Data();

    @Override
    public void start(Stage window) {
        BorderPane layout=new BorderPane();
        window.setTitle("Welcome");
        ImageView View = new ImageView("D:/Second Sem/Java 2/Fitness/src/fitness/main.jpg");
    
        // set the size and position of the ImageView
        View.setFitWidth(500);
        View.setFitHeight(500);
        View.setPreserveRatio(false);
        View.setSmooth(true);
        View.setCache(true);

        // add the ImageView to the layout
        layout.getChildren().add(View);
        
        HBox main=new HBox(20);
        main.setPadding(new Insets(20,20,50,50));
        
        Button login=new Button("log in");
        Button signup=new Button("Sign up");
        
        signup.setOnAction(e-> signup());
        
        login.setOnAction(e-> login());
        
        
        main.getChildren().addAll(login,signup);
        
        main.setAlignment(Pos.TOP_RIGHT);
        
        Line line=new Line(0,70,500,70);
        layout.setTop(main);
        layout.getChildren().add(line);
        Scene scene=new Scene(layout,500,500);
        
        window.setScene(scene);;
        window.show();
            
    }
    
    public void signup() {
        
        Stage signStage=new Stage();
        GridPane pane=new GridPane();
        
        //Fullname label
        pane.add(new Label("Full Name"), 0, 0);
        pane.add(fullname, 1, 0);
        
        fullname.setAlignment(Pos.BOTTOM_RIGHT);

        //Email label
        pane.add(new Label("Email"), 0, 1);
        pane.add(email, 1, 1);
        
        email.setAlignment(Pos.BOTTOM_RIGHT);
        
        //Conformemail label
        pane.add(new Label("Conform Email"), 0, 2);
        pane.add(conformemail, 1, 2);
        
        conformemail.setAlignment(Pos.BOTTOM_RIGHT);
        
        //Phonenumber label
        pane.add(new Label("Phone Number"), 0, 3);
        pane.add(phonenumber, 1, 3);
        
        phonenumber.setAlignment(Pos.BOTTOM_RIGHT);
        
        //password label
        pane.add(new Label("Set Password"), 0, 4);
        pane.add(password, 1, 4);
        
        password.setAlignment(Pos.BOTTOM_RIGHT);
        
        Button sign=new Button("Sign in");
        pane.add(sign, 1, 5);
        GridPane.setHalignment(sign, HPos.RIGHT);
        
        Label mess=new Label("");
        pane.add(mess, 0, 7);
        
        sign.setOnAction(e -> {
            while (true) {
                String fullName = fullname.getText();
                String emailText = email.getText();
                String conformEmailText = conformemail.getText();
                String phoneNumberText = phonenumber.getText();
                String passwordText = password.getText();

                try {
                    
                    if (fullName == null || fullName.isEmpty() ||
                        emailText == null || emailText.isEmpty() ||
                        conformEmailText == null || conformEmailText.isEmpty() ||
                        phoneNumberText == null || phoneNumberText.isEmpty() ||
                        passwordText == null || passwordText.isEmpty()) {
                        
                        throw new Exception("Please fill in all the details.");
                    } 

                    if (!Valid(emailText)) {
                        
                        throw new Exception("Please enter a valid email address.");
                    } 

                    if (!emailText.equals(conformEmailText)) {
                        
                        throw new Exception("The email addresses you entered do not match.");
                    } 

                    if (!fullName.matches("^[a-zA-Z]*$")) {
                        
                        throw new Exception("Please enter a valid name.");
                    } 

                    if (phoneNumberText.length() != 10 || !phoneNumberText.matches("\\d+")) {
                        
                        throw new Exception("Please enter a 10-digit phone number.");
                    } 

                    if (passwordText.length() < 5) {
                        
                        throw new Exception("Password must be at least 5 characters long.");
                    }

                    // all input is valid
                    data.saveData(fullName, emailText, phoneNumberText, passwordText);
                    data.print();
                    
                    return; // exit the method
                } 
                
                catch (Exception ex) {
                    
                    mess.setText(ex.getMessage());
                    mess.setTextFill(Color.RED);
                    
                    break; // exit the loop and wait for user input again
                }
            }
        });

        pane.setAlignment(Pos.CENTER);
        Scene scene=new Scene(pane,500,500);
        
        signStage.setScene(scene);
        signStage.show();
        
    }
    
    public void login() {
        
        Stage logStage =new Stage();
        
        GridPane layout =new GridPane();
        
        TextField emailtextField=new TextField();
        layout.add(new Label("Email"), 0, 1);
        
        layout.add(emailtextField, 1, 1);
        emailtextField.setAlignment(Pos.BOTTOM_RIGHT);
        
        PasswordField passwordtextField=new PasswordField();
        layout.add(new Label("Password"), 0, 2);
        
        layout.add(passwordtextField, 1, 2);
        passwordtextField.setAlignment(Pos.BOTTOM_RIGHT);
        
        Button log=new Button("Log in");
        
        layout.add(log, 1, 5);
        GridPane.setHalignment(log, HPos.RIGHT);
        
        log.setOnAction(e -> {
            
        String[] userData = data.loadData();
        
        if (userData == null || !userData[1].equals(emailtextField.getText())
                || !userData[3].equals(passwordtextField.getText())) {
            
            System.out.println("Wrong details");
            // Login failed
            // Show an error message or do something else
        } 
        
        else {
            
             System.out.println("Login successful");
            // Proceed with the rest of the application
        }
    });
        
        layout.setAlignment(Pos.CENTER);
        
        Scene scene=new Scene(layout,500,500);
        
        logStage.setScene(scene);
        logStage.show();
        
    }
    
    public static boolean Valid(String email) {
        
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,}$";
        
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    //main method
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
