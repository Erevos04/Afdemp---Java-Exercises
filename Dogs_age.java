/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogs_age;

import java.util.Scanner;

/**
 *
 * @author Orestis
 */
public class Dogs_age {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
{
int x = 0;

Scanner scanner = new Scanner(System.in);
System.out.println("Give dog's age:");
x=scanner.nextInt();

while ((x<=0) || (x>30))
    {
    System.out.println("Wrong age. Give another dog's age.");
    x=scanner.nextInt();
    }  
if ((x>0 && x<=2))
    {
     System.out.println("Dog's human age is:" +x);
    }
else
    {
    System.out.println("Dog's human age is:" +((x-2)*5+2));}
    }  
}