package fitness;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ExerciseData {
    
    Image logo = new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\logo.jpg");
    
    Image background=new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\background.jpg");
    
    ImageView Logo = new ImageView(logo);
    
    public void homeExercise(String key) {
        Stage home=new Stage();
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        
        grid.setAlignment(Pos.TOP_CENTER);
        home.getIcons().add(logo);
        
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
        
        Logobox.setAlignment(Pos.CENTER);
        
        GridPane.setValignment(Logobox, VPos.TOP);
        
        
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
        ArrayList<String> data=new ArrayList<>();
        int indexstart=lines.indexOf("ExerciseplanStart");
        int indexend=lines.indexOf("ExerciseplanEnd");
        List<String> specificData = lines.subList(indexstart+1, indexend-1);
        System.out.println(specificData);
        String levelvalue=specificData.get(0);
        String pushupvalue=specificData.get(1);
        String squadsvalue=specificData.get(2);
        int lp,pv,sv;
        if(levelvalue.equals("Beginner")) {
           lp=1;
        }
        else if(levelvalue.equals("Intermediate")) {
            lp=2;
        }
        else {
            lp=3;
        }
        if(pushupvalue.equals("Less than 5 pushups")) {
           pv=3;
        }
        else if(pushupvalue.equals("5 to 10 pushups")) {
            pv=8;
        }
        else {
            pv=15;
        }
        if(squadsvalue.equals("Less than 10")) {
           sv=7;
        }
        else if(squadsvalue.equals("10 to 20 squads")) {
            sv=15;
        }
        else {
            sv=25;
        }

        ImageView mountain = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\moutane.png"));
        ImageView squads = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\squads.png"));
        ImageView pushup = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\pushup.png"));
        
        ImageView jump = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\jump.png"));
        ImageView strech = new ImageView(new Image("D:\\Second Sem\\Java 2\\Fitness\\src\\fitness\\strech.png"));
        
        mountain.setFitWidth(70);
        mountain.setFitHeight(70);
        
        squads.setFitWidth(70);
        squads.setFitHeight(70);
        
        pushup.setFitWidth(70);
        pushup.setFitHeight(70);
        
        jump.setFitWidth(70);
        jump.setFitHeight(70);
        
        strech.setFitWidth(70);
        strech.setFitHeight(70);
        
        
        
        
        
        
        
        // create HBox for each image
        HBox mountainBox = new HBox(mountain);
        
        HBox mountainBoxlabel=new HBox();
        
        Label MountainClimber=new Label("Mountain Climber\nFor 30 seconds");
        mountainBoxlabel.getChildren().add(MountainClimber);
        
        grid.add(mountainBox, 0, 1);
        grid.add(MountainClimber, 1, 1);

        
        
        HBox squadsBox = new HBox(squads);
        
        HBox squadsBoxlabel=new HBox();
        
        Label squadslabel=new Label("Squads\nNumbers of reps="+sv);
        squadsBoxlabel.getChildren().add(squadslabel);
        
        grid.add(squadsBox, 0, 2);
        grid.add(squadsBoxlabel, 1, 2);
        
        
        
        HBox pushupBox = new HBox(pushup);
        
        HBox pushupBoxlabel=new HBox();
        
        Label puchuplabel=new Label("Push ups\nNumbers of reps="+pv);
        pushupBoxlabel.getChildren().add(puchuplabel);
        
        grid.add(pushupBox, 0, 3);
        grid.add(pushupBoxlabel, 1, 3);
        
        
        
        HBox jumpBox = new HBox(jump);
        
        HBox jumpBoxlabel=new HBox();
        
        Label jumplabel=new Label("Jumping\nFor 30 seconds");
        jumpBoxlabel.getChildren().add(jumplabel);
        
        grid.add(jumpBox, 0, 4);
        grid.add(jumpBoxlabel, 1, 4);
        
        
        
        HBox strechBox = new HBox(strech);

        HBox strechBoxlabel=new HBox();
        
        Label Strechlabel=new Label("Streching\nFor 30 seconds");
        strechBoxlabel.getChildren().add(Strechlabel);
        
        grid.add(strechBox, 0, 5);
        grid.add(strechBoxlabel, 1, 5);

        
        
        Scene scene = new Scene(grid,400,550);
        home.setScene(scene);
        home.show();
    }
}