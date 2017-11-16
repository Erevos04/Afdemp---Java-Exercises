package factorial;

import java.util.Scanner;

/**
 *
 * @author Orestis
 */
public class Factorial {

    public static void main(String[] args) {
    int i,fact=1;  
    Scanner sc = new Scanner(System.in);
    System.out.println("Please give number to calculate factorial : ");
    int number=sc.nextInt();    
    for(i=1;i<=number;i++){
        fact=fact*i;    
    }    
    System.out.println("Factorial of "+number+" is: "+fact);    
    }  
    }