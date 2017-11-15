/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sja2;
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
    }