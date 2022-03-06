import java.util.Date;

public  class  AlfredQuotes { 
    public  String basicGreeting() { 
        return  "Hello, nice to see you. How are you?" ; 
    } 

    public  String guestGreeting(String name) {  
        return  "placeholder for the greeting return string guest" ;  
    }  

    public  String dateAnnouncement() { 
        Date myDate = new Date() ;
        return   "the date today is " + myDate ;   
    }  

    public String conversation() {  
        return  "for sarcastic reply return string" ;   
    }

    public String respondBeforeAlexis(String sts) {
        return sts;
    }  
}   