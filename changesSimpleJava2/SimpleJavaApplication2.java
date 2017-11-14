package simplejavaapplication2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class SimpleJavaApplication2 {
    
    public static final int LNAME=0;
    public static final int FNAME=1;
    public static final int FATNAME=2;
    public static final int DATEBIRTH=3;

    
    public static void main(String[] args) throws ParseException, Exception {
       Person prs = new Person();
       Scanner stdin = new Scanner(System.in);
       
       System.out.println("What is your last_name?");
       prs.setString(LNAME,stdin.nextLine());
       System.out.println("What is your first_name?");
       prs.setString(FNAME,stdin.nextLine());
       System.out.println("What is your father_name?");
       prs.setString(FATNAME,stdin.nextLine());
       System.out.println("Give your date of birth on format DD/MM/YYYY");
       prs.setString(DATEBIRTH,stdin.nextLine());
       
       stdin.close();
       System.out.println("printing........");
       String filename=""+prs.getString(LNAME)+"."+prs.getString(FNAME)+".txt";
       WriteString wrs = new WriteString(filename);
       
       for(int i=1;i<=3;i++){
           if(i==1){
               String k=""+ prs.getString(LNAME) +", "+prs.getString(FNAME)+", "+prs.getString(FATNAME)+"";
               wrs.writes(i, k);
           }else if(i==2){
               String k=prs.getString(DATEBIRTH);
               wrs.writes(i, k);
           }else{
               SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY"); 
               Calendar dob = Calendar.getInstance(); 
               dob.setTime(sdf.parse(prs.getString(DATEBIRTH))); 
               String k = ""+getAge(dob)+"";
               wrs.writes(i, k); 
           }
       }
       System.out.println("file is ready");
       ReadStrings rds = new ReadStrings();
       rds.reads(filename);
            
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