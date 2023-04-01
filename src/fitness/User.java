package fitness;

import java.awt.Image;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class User extends Application {
    
    TextField fullname=new TextField();
    
    TextField email=new TextField();
    
    TextField conformemail=new TextField();
    
    TextField phonenumber=new TextField();
    
    TextField password=new TextField();
    
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
        
        Line line=new Line(0,100,500,100);
        layout.setTop(main);
        layout.getChildren().add(line);
        Scene scene=new Scene(layout,500,500);
        
        window.setScene(scene);;
        window.show();
            
    }
    
    public static void main(String[] args) {
        
        launch(args);
        
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
        pane.add(mess, 0, 6);
        
        sign.setOnAction(e -> {
            if (fullname.getText() == null || email.getText() == null || conformemail.getText() == null
                    || phonenumber.getText() == null || password.getText() == null) {
                
                mess.setText("Please fill all the details");
                mess.setTextFill(Color.RED);
            } 
            else {
                data.saveData(fullname.getText(), email.getText(), phonenumber.getText(), password.getText());
                plan();
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
        
        TextField passwordtextField=new TextField();
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
    public void plan() {
        Stage plans=new Stage();
        Label heading=new Label("Please choose your plans");
        BorderPane pane=new BorderPane();
        pane.setTop(heading);
        
        
        Scene scene=new Scene(pane,500,500);
        plans.setScene(scene);
        plans.show();
        
    }
    
}
