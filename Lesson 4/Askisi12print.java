/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askisi12print;

import java.util.Scanner;

/**
 *
 * @author Orestis
 */
public class Askisi12print {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x=0;
    
       
       Scanner scanner = new Scanner(System.in);
       System.out.println("Give a number : ");
        x=scanner.nextInt();
        System.out.println("Give a word : ");
        String y = scanner.next();
        System.out.println("Your number and word is : " +x+" and " +y);
    }
    
}
