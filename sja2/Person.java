/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sja2;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Orestis
 */
public class Person {

private String Name;
    public void setName(String Name){
    this.Name = Name;
}
    public String getName(){
    return this.Name;
}



private String Surname;
    public void setSurname(String Surname){
    this.Surname = Surname;
}
    public String getSurname(){
    return this.Surname;
}


private String Fathersname;
    public void setFathersname(String Fathersname){
    this.Fathersname = Fathersname;
}
    public String getFathersname(){
    return this.Fathersname;
}


private String Dob;
    public void setDob(String Dob){
    this.Dob = (Dob.substring(6, 10));
}
    public String getDob(){
    return this.Dob;
}


private String Colour;
    public void setColour(String Colour){
    this.Colour = Colour;
}
    public String getColour(){
    return this.Colour;
}
    
private int YearNow = Calendar.getInstance().get(Calendar.YEAR);

    public void PrintToTextFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter ("lastname.firstname.txt" ,"UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int x=1;x<=3;x++){ 
            writer.println("Line "+x+": You are "+Name+" "+Surname+" of "+Fathersname+".");
            writer.println("Line "+(x+=1)+": Year of Birth is "+Dob+".");
            writer.println("Line "+(x+=1)+": Your age is "+(YearNow-(Integer.parseInt(Dob)))+".");
            writer.close();}
    }    
    
}