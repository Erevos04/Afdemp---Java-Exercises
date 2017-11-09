/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askisi.pkg2.pkg3.arithmoi;

import java.util.Scanner;

/**
 *
 * @author Orestis
 */
public class Askisi23Arithmoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int x=0;
    int y=0;
    int z=0;
        
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give first number : ");
    x=scanner.nextInt();
    System.out.println("Give second number : ");
    y=scanner.nextInt();
    System.out.println("Give third number : ");
    z=scanner.nextInt();
    
    while ((y<(2*x)) || (z<(x+y)))
    {
        System.out.println("Give another first number : ");
        x=scanner.nextInt();
        System.out.println("Give another second number : ");
        y=scanner.nextInt();
        System.out.println("Give another third number : ");
        z=scanner.nextInt();
        }
    System.out.println("Great! Your numbers are :" +x+", " +y+", " +z+".");
    }
    
}
