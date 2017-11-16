/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sja2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orestis
 */
public class Readprint {
    Person newPerson = new Person();
    
    public Person ReadfromPrint(Person person){
        String filedir = "C:\\temp\\temp1\\"+person.getSurname()+" "+person.getName()+".txt";
        FileReader fileReader = null;
        String line;
        String readingOutcome;
        try {
            fileReader = new FileReader(filedir);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Readprint.class.getName()).log(Level.SEVERE, null, ex);
        }
	BufferedReader bufferedReader = new BufferedReader(fileReader);
	StringBuffer stringBuffer = new StringBuffer();
        
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Readprint.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Readprint.class.getName()).log(Level.SEVERE, null, ex);
        }
			readingOutcome=stringBuffer.toString();
			System.out.println(readingOutcome);
        
        String [] arrOutcome = readingOutcome.split(" ", 0);
        newPerson.setName(arrOutcome[4]);
        newPerson.setSurname(arrOutcome[5]);
        newPerson.setFathersname(arrOutcome[7]);
        newPerson.setnewDob(arrOutcome[14]);
        
        System.out.println("If this worked, your name is "+newPerson.getName()+" "+newPerson.getSurname()+" and your year of birth is "+newPerson.getnewDob()+".");
        return newPerson;
}
}