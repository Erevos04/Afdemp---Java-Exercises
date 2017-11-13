/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sja2;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Orestis
 */
public class SJA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    Scanner sc = new Scanner(System.in);
    Person person = new Person();
    System.out.println("Hello, what is your name? ");
    person.setName(sc.next());{
    System.out.println("Your name is "+person.getName()+". What is your surname? ");}
    person.setSurname(sc.next());{
    System.out.println("It seems you are "+person.getName()+" "+person.getSurname()+". What is your father's name then? ");}
    person.setFathersname(sc.next());{
    System.out.println("What's your date of birth? (Format only dd/MM/YYYY) ");}
    person.setDob(sc.next());{
    System.out.println("Your year of birth is "+person.getDob()+". What is your favorite colour? ");}
    person.setColour(sc.next());{
    System.out.println("Your favorite colour is "+person.getColour());}
    System.out.println("Printing your personal data to the file 'lastname.firstname.txt' ...........\nThank you!");
    person.PrintToTextFile();
    }
}
