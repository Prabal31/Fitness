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
import javafx.scene.layout.GridPane;
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
        GridPane pane=new GridPane();
        window.setTitle("Welcome");
        
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
        window.setScene(scene);
        window.show();

        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
