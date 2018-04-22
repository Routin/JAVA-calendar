package calendary;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.*;

public class CalendarFrame extends JFrame implements ActionListener,ItemListener{
    private static final long serialVersionUID = 1L;
    
    JLabel labelDay[]=new JLabel[42];
    JButton titleName[]=new JButton[7];                                     
    JTextField text;                                                        
    JButton button,button1;                                                 
    JLabel label1,label2;                                                                       
    JComboBox<String> comBox;                                                       
    String name[]={"日","一","二","三","四","五","六"};                            
    CalendarBean calendar;                                                  
    JLabel showMessage=new JLabel("",JLabel.CENTER);                        

    int year=2011,month=2;
    
    public CalendarFrame(){ 
        
        JPanel pCenter=new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon(".\\src\\1.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        setVisible(true);        
        
        pCenter.setLayout(new GridLayout(7,7)); 
        pCenter.setBackground(Color.WHITE);
        
        for(int i=0;i<7;i++){                                               
            titleName[i]=new JButton(name[i]);                              
            titleName[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));    
            //titleName[i].setBackground(Color.green);
            pCenter.add(titleName[i]);                                      
        }                                                                   
        
        for(int i=0;i<42;i++){                                              
            labelDay[i]=new JLabel("",JLabel.CENTER);
            labelDay[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));    
            pCenter.add(labelDay[i]);                                       
        }                 
                                                                         
        calendar=new CalendarBean();    
                                                                         
        text=new JTextField(3); 
        text.setText("2018");
        button=new JButton("查询");                                   
        button1=new JButton("当前日期");                                        
        label1=new JLabel("                          万年历           ");

        label1.setForeground(Color.WHITE);
                                                                         
        label1.setFont(new Font("",1,30));  
                 
        label2=new JLabel("今日：");
        label2.setForeground(Color.WHITE);
        comBox=new JComboBox<String>();                                                                                         
        String []a={"1","2","3","4","5","6","7","8","9","10","11","12"};
        for(int i=0;i<a.length;i++)                                         
        comBox.addItem(a[i]);       
                                                                         
        button.addActionListener(this);                                 
        button1.addActionListener(this);                                    
        comBox.addItemListener(null);   
                                                                         
        JPanel pNorth=new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon(".\\src\\2.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        setVisible(true);  ; 
        pNorth.setBackground(Color.white);
        JPanel pSouth=new JPanel();     
                                                                         
        pNorth.add(label1);     
        pNorth.add(label2);                                                                                                                                  
        pSouth.add(text);
        pSouth.add(new JLabel("年"));                    
        pSouth.add(comBox); 
        pSouth.add(new JLabel("月"));                                                                                        
        pSouth.add(button);                                                 
        pSouth.add(showMessage);  
        pSouth.add(button1);  
                                                                         
        add(pCenter,BorderLayout.CENTER);                                   
        add(pNorth,BorderLayout.NORTH);                                     
        add(pSouth,BorderLayout.SOUTH);     
                                                                         
        setYearAndMonth(year,month);
                                                                         
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);                         
    }
    
    public void setYearAndMonth(int y,int m){                               
        calendar.setYear(y);
                                                                         
        calendar.setMonth(m);       
         
        String day[]=calendar.getCalendar();
        for(int i=0;i<42;i++) {                                              
        	labelDay[i].setForeground(Color.CYAN);
        	labelDay[i].setFont(new Font("",1,20));
            labelDay[i].setText(day[i]);  
        }
         
        showMessage.setText("日历："+calendar.getYear()+"年"+calendar.getMonth()+"月");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        label2.setText("今日:"+df.format(new Date()));
         
        showMessage.setForeground(Color.RED);                              
    }                                                                       
     
    public void actionPerformed(ActionEvent e){                             
        
        String reg="^[\\d]*$";
        
        if(e.getSource()==button){                                          
             
            if(text.getText().isEmpty()){               

                JOptionPane.showMessageDialog(this, "您未输入年份", "消息对话框", JOptionPane.WARNING_MESSAGE);
                
                text.requestFocus(true);
            }
            
            else if(!(text.getText()).matches(reg)){
            JOptionPane.showMessageDialog(this, "您输入了非法字符", "消息对话框", JOptionPane.WARNING_MESSAGE);
            }
            
            else {

                 
            Integer i=Integer.parseInt(text.getText()); 
            
            calendar.setYear(i);
            }


            
            if(((String)comBox.getSelectedItem()).equals("选择月份"))   {           
                JOptionPane.showMessageDialog(this, "您未选择月份", "消息对话框", JOptionPane.WARNING_MESSAGE);
                
                comBox.requestFocus(true);
            }
            else{
             
            Integer j=Integer.parseInt(comBox.getSelectedItem().toString());
             
            calendar.setMonth(j);                                           
             
            String day[]=calendar.getCalendar();                            
             
            for(int n=0;n<42;n++){
            	labelDay[n].setForeground(Color.cyan);
                labelDay[n].setText(day[n]);    
            }
            }
             
            showMessage.setText("日历："+calendar.getYear()+"年"+calendar.getMonth()+"月");
        }
         
        else if(e.getSource()==button1){        
             
            Calendar c=Calendar.getInstance();                              
            int y=c.get(Calendar.YEAR);                                     
            int m=c.get(Calendar.MONTH)+1;
            calendar.setYear(y);
            calendar.setMonth(m);
            String day[]=calendar.getCalendar();                            
            for(int n=0;n<42;n++){
            	labelDay[n].setForeground(Color.cyan);
                labelDay[n].setText(day[n]);
            }
            showMessage.setText("日历："+y+"年"+m+"月"); 
            text.setText("");
        }                                                                   
         
        showMessage.setForeground(Color.RED);                              
    }
     
    public void itemStateChanged(ItemEvent arg0) {                          
        // TODO Auto-generated method stub                                  
    }                                                                       
}