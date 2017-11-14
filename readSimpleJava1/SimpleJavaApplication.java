package simplejavaapplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SimpleJavaApplication {

    
    public static void main(String[] args) throws ParseException, Exception {
       
        Scanner stdin = new Scanner(System.in);
        System.out.println("What is your last_name?");
        String lname = stdin.nextLine();
        System.out.println("What is your first_name?");
        String fname = stdin.nextLine();
        System.out.println("What is your father_name?");
        String fat_name = stdin.nextLine();
        System.out.println("Give your date of birth on format DD/MM/YYYY");
        String birth_d = stdin.nextLine();

        stdin.close();
        
        System.out.println("printing........");
        String filename=""+lname+"."+fname+".txt";
        
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for(int i=1;i<=3;i++){
               if(i==1){ 
                  writer.println("Line "+i+": "+ lname + ", "+fname+", "+fat_name+"");
               }else if(i==2){
                  writer.println("Line "+i+": "+birth_d);   
               }else{
                  SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY"); 
                  Calendar dob = Calendar.getInstance(); 
                  dob.setTime(sdf.parse(birth_d)); 
                  writer.println("Line "+i+": "+getAge(dob));
               }
            }
            writer.close();
            System.out.println("file is ready");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SimpleJavaApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SimpleJavaApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String r_line = null;
        
         try{
             FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
         
            while((r_line = bufferedReader.readLine()) != null) {
                System.out.println(r_line);
            }   
            
             bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            Logger.getLogger(SimpleJavaApplication.class.getName()).log(Level.SEVERE, null, ex);              
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + filename + "'");                  
        }

    }
    
    public static int getAge(Calendar dob) throws Exception {
        Calendar today = Calendar.getInstance();

        int curYear = today.get(Calendar.YEAR);
        int dobYear = dob.get(Calendar.YEAR);

        int age = curYear - dobYear;
        int curMonth = today.get(Calendar.MONTH);
        int dobMonth = dob.get(Calendar.MONTH);
        if (dobMonth > curMonth) { 
            age--;
        } else if (dobMonth == curMonth) { 
            int curDay = today.get(Calendar.DAY_OF_MONTH);
            int dobDay = dob.get(Calendar.DAY_OF_MONTH);
            if (dobDay > curDay) { 
                age--;
            }
        }

        return age;
    }

}