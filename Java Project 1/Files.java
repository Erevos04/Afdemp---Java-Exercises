/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Orestis
 */
class Files {
    
    protected void SendStatement(String username) {
            String datenow = new SimpleDateFormat("dd_MM_yyyy").format(new Date());
            
            
        String path1= "C:\\Bank Application Logs";
        File f = new File(path1);
        boolean check = f.isDirectory();
        if (!check) {
            f.mkdirs();
        }           
            PrintWriter writer = null;
            FileWriter flwriter=null;
            
            
            if(username.equals("admin")){
               
                try {
                    flwriter = new FileWriter("C:\\Bank Application Logs\\Statement_"+username+"_"+datenow+".txt",true);
                } catch (IOException ex) {
                    System.out.println("Error creating Statement.");
                }
                    
                    writer = new PrintWriter (flwriter);
                    System.out.println("Creating Statement...");
                    for(String st : new Database().getStatement()){                       
                        writer.println(st);                       
                    }
                    System.out.println("Statement succesfully created.");
                try {
                    flwriter.close();
                } catch (IOException ex) {
                    System.out.println("Error creating Statement.");
                    }
                writer.close();
                new Database().clearStatement();
            } 
                       
            else
                {
                try {
                    flwriter = new FileWriter("C:\\Bank Application Logs\\Statement_user_"+username.substring(4)+"_"+datenow+".txt",true);
            } catch (IOException ex) {
                System.out.println("Error creating Statement.");
            }
               
            writer = new PrintWriter (flwriter);
            System.out.println("Creating Statement...");
            for(String st : new Database().getStatement()){
                
                writer.println(st);
                
            }
            System.out.println("Statement succesfully created.");
            try {
                flwriter.close();
            } catch (IOException ex) {
                System.out.println("Error creating Statement.");
            }
            writer.close();
            new Database().clearStatement();
        } 
    }   
}
