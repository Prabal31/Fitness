package fitness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
    
}
