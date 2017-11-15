/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sja2;

import java.io.File;
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
public class Createprint {
    Person person = new Person();
    
    private int YearNow = Calendar.getInstance().get(Calendar.YEAR);

    public void PrintToTextFile(Person person){
        String path = "C:\\temp";
        String path1= "C:\\temp\\temp1";
        File f = new File(path1);
        boolean check = f.isDirectory();
        if (check) {
        System.out.println("Folder C:\\temp\\temp1 already exists");}
        else {
        System.out.println("Folder does not exist");
        f.mkdirs(); 
        System.out.println("Folder Created");}
        System.out.println("Printing your personal data to the file : " +person.getSurname()+" "+person.getName()+".txt ...........\nThank you!");
        
        PrintWriter writer = null;
        try {
            writer = new PrintWriter ("C:\\temp\\temp1\\"+person.getSurname()+" "+person.getName()+".txt","UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int x=1;x<=3;x++){ 
            if (x==1){
                writer.println("Line "+x+": You are "+person.getName()+" "+person.getSurname()+" of "+person.getFathersname()+" .");
            }
            if (x==2){
                writer.println("Line "+x+": Year of Birth is "+person.getDob()+" .");
            }
            if (x==3){
                writer.println("Line "+x+": Your age is "+(YearNow-(Integer.parseInt(person.getDob())))+" .");
            }
            }
            
            writer.close();}
    
}
