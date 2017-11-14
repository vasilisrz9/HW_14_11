package simplejavaapplication2;


public class Person {
    private String first_name;
    private String last_name;
    private String father_name;
    private String dateofbirth;

    public void setString(int i, String s){
        if(i==0){
          this.last_name = s;  
        }else if(i==1){
          this.first_name = s;  
        }else if(i==2){
          this.father_name = s;  
        }else{
          this.dateofbirth = s;  
        }
    }
    
    public String getString(int i){
        if(i==0){
          return last_name;  
        }else if(i==1){
          return first_name;  
        }else if(i==2){
          return father_name;  
        }else{
          return dateofbirth;  
        }
    }
    
}