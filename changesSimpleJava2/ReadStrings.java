package simplejavaapplication2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReadStrings {
    
    public void reads(String filename){
        String r_line = null;

    try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((r_line = bufferedReader.readLine()) != null) {
                System.out.println(r_line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            Logger.getLogger(ReadStrings.class.getName()).log(Level.SEVERE, null, ex);              
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + filename + "'");                  
        }
    }
}
            
    