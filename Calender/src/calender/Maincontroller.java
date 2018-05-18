package calender;
import com.sun.prism.paint.Color;
import java.awt.Paint;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JPanel;


public class Maincontroller implements Initializable{
    
    String []monthName={"January","February","March","April","May","June","July","August","September","October","November","December"};
    int []monthDay={31,28,31,30,31,30,31,31,30,31,30,31};
    int [] fdayofMonth=new int[12];
    int firstdayofyear=0;
    int day;
    int year;
    int month;
    int firstdayofmonth;
    String monString;
    int mon;
    Date date= new Date();
      
    @FXML
    private  Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30,l31,l32,l33,l34,l35;
    @FXML
    private Label currentM;
    @FXML
    private Label mymessege;
    @FXML
    private TextField yearInputField=null;
    @FXML
    private Label monthTitle;
    @FXML
    private Button nextButton,prevButton;
    
    @FXML
    private ComboBox <String> comboBox;
    ObservableList<String> list=FXCollections.observableArrayList(monthName);
  @Override
    public void initialize(URL location, ResourceBundle resources) {

       comboBox.setItems(list);
       month=getcurrentmonth();
       year=getcurrentyear();
       currentM.setText(monthName[getcurrentmonth()]);
    
        monthTitle.setText(monthName[month]);
        generatemonthfday(getFirstdayOfYear(year));
        for(int i=0;i<12;i++){
            System.out.println(fdayofMonth[i]);
        }
        showCalender(getMonthFday(month));
     }
    public void getYearinput(ActionEvent event){
        year=Integer.parseInt(yearInputField.getText());
           
    }
    
    public void combochange(ActionEvent event){
       monthTitle.setText(comboBox.getValue());
       if(yearInputField!=null){year=Integer.valueOf(yearInputField.getText());}
       else {year=getcurrentyear();}
    
       month=monthdaycounter(comboBox.getValue());
      
   
      
      generatemonthfday(getFirstdayOfYear(year));
       
        showCalender(getMonthFday(month));
        
   }
   
    public int getcurrentmonth(){
        
       int dat=date.getMonth();
       return dat;
       }
    public int getcurrentyear(){
        int dat=date.getYear();
        dat=dat+1900;
        return dat;
    }
    public int getcurrentday(){
        int dat=date.getDate();
        return dat;
    }
    public int monthdaycounter(String month){
         if(month.equals("January")){return 0;}
        else if(month.equals("February")){return 1;}
        else if(month.equals("March")){return 2;}
        else if(month.equals("April")){return 3;}
        else if(month.equals("May")){return 4;}
        else if(month.equals("June")){return 5;}
        else if(month.equals("July")){return 6;}
        else if(month.equals("August")){return 7;}
        else if(month.equals("September")){return 8;}
        else if(month.equals("October")){return 9;}
        else if(month.equals("November")){return 10;}
        else if(month.equals("December")){return 11;}
        return 0;
        }
    public void generatemonthfday(int day){
        
    
          int totalmday=day;
          fdayofMonth[0]=day;
       
        for(int i=1;i<12;i++){
            totalmday+=monthDay[i-1];
            fdayofMonth[i]=totalmday%7;
            
            if(fdayofMonth[i]==0){
             fdayofMonth[i]=7;}}
   }
    public int getMonthFday(int month)
    { 
        return fdayofMonth[month];
        
    }
    public void showCalender(int d){
        if(d==7){d=0;}
     Label[]label= new Label[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30,l31,l32,l33,l34,l35};
      for(int i=0;i<35;i++){
          
          label[i].setStyle("-fx-text-fill: #000000");
      }
        for(int i=0;i<d;i++){
           label[i].setText(" ");
        }
        int j=1;
        for(int i=d;i<d+monthDay[month];i++){
            label[i].setText(Integer.toString(j));
            j++;}
       
        if(year==getcurrentyear()&&month==getcurrentmonth()){
            int a;
            a=getcurrentday();
            label[d+a-1].setStyle("-fx-text-fill: #cf1020");
        }
       
       
       int k=d+monthDay[month];
       
      for(int l=k;l<35;l++){
          label[l].setText(" ");
      }
        
        
    }
    public int getFirstdayOfYear(int year){
        
         day = (((year - 1) * 365) + ((year - 1) / 4) - ((year - 1) / 100) + ((year) / 400) + 1) % 7;
         if ((year%4==0&&year%100!=0)||(year%400==0)){
            monthDay[1]=29;
          }
         if(day==0){firstdayofyear=1;}
       else if(day==1){firstdayofyear=2;}
       else if(day==2){firstdayofyear=3;}
       else if(day==3){firstdayofyear=4;}
       else if(day==4){firstdayofyear=5;}
       else if(day==5){firstdayofyear=6;}
       else if(day==6){firstdayofyear=7;}
        return firstdayofyear;
    }
   
   }
