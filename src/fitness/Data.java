package fitness;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Data {
    
    public void saveData(String name, String email, String phone, String password) {
        
        try {
            
            FileWriter writer = new FileWriter("user_data.txt");
            writer.write(name + "," + email + "," + phone + "," + password);
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
