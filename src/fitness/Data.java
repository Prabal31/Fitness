package fitness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Data {
    
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
    public void print() {
        Stage plans = new Stage();
        Label heading = new Label("Details");
        heading.setAlignment(Pos.CENTER);
        heading.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        BorderPane pane = new BorderPane();
        pane.setTop(heading);
        BorderPane.setAlignment(heading, Pos.CENTER);
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 0, 0, 0));

        try {
            
            BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"));
            String line = reader.readLine();
            while (line != null) {
                
                String[] details = line.split(",");
                String name = details[0];
                String email = details[1];
                String phone = details[2];
                Label nameLabel = new Label("Name: " + name);
                Label emailLabel = new Label("Email: " + email);
                Label phoneLabel = new Label("Phone: " + phone);
                vbox.getChildren().addAll(nameLabel, emailLabel, phoneLabel);
                line = reader.readLine();
                
            }
            
            reader.close();
        } 
        
        catch (IOException e) {
            
            e.printStackTrace();
        }

        pane.setCenter(vbox);

        Scene scene = new Scene(pane, 500, 500);
        plans.setScene(scene);
        plans.show();
    }
}
