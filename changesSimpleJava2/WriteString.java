package simplejavaapplication2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WriteString {
    
    private String filename;
    
    public WriteString(String filename) {
        this.filename = filename;
    }
    
    public void writes(int lin, String s){
        
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(this.filename,true));
            writer.println("Line "+lin+": "+s);
            writer.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteString.class.getName()).log(Level.SEVERE, null, ex);
        }catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WriteString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
