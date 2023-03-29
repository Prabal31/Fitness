package fitness;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class User extends Application {
    
    TextField fullname=new TextField();
    TextField email=new TextField();
    TextField conformemail=new TextField();
    TextField phonenumber=new TextField();
    TextField password=new TextField();
    Button submit=new Button("Submit");
    


    @Override
    public void start(Stage window) {
        
        window.setTitle("Welcome");
        
        HBox main=new HBox();
        
        Button login=new Button("log in");
        Button signup=new Button("Sign up");
        
        signup.setOnAction(e-> signup());
        
        login.setOnAction(e-> login());
        
        
        main.getChildren().addAll(login,signup);
        main.setAlignment(Pos.CENTER);
        BorderPane layout=new BorderPane();
        layout.setCenter(main);
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
        
        //Submit buttom
        pane.add(submit, 1, 5);
        GridPane.setHalignment(submit, HPos.RIGHT);
        
        
        pane.setAlignment(Pos.CENTER);
        Scene scene=new Scene(pane,500,500);
        signStage.setScene(scene);
        signStage.show();
    }
    public void login() {
        Stage logStage =new Stage();
        GridPane layout =new GridPane();
        TextField emailtextField=new TextField();
        layout.add(new Label("Email"), 0, 2);
        layout.add(emailtextField, 1, 2);
        emailtextField.setAlignment(Pos.BOTTOM_RIGHT);
        
        TextField passwordtextField=new TextField();
        layout.add(new Label("Password"), 0, 1);
        layout.add(passwordtextField, 1, 1);
        passwordtextField.setAlignment(Pos.BOTTOM_RIGHT);
        
        layout.setAlignment(Pos.CENTER);
        
        Scene scene=new Scene(layout,500,500);
        
        logStage.setScene(scene);
        logStage.show();
        
    }
    
}
