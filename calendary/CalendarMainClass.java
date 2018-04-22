package calendary;

public class CalendarMainClass {                                

    
    public static void main(String[] args) {
        
        CalendarFrame frame=new CalendarFrame();        
        
        frame.setBounds(200,150,670,490);   
        
        frame.setVisible(true);     
        
        frame.setYearAndMonth(2018,4);                          
        
        frame.setTitle("ÍòÄêÀú");      


    }

}