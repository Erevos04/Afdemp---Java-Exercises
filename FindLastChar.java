/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findlastchar;

/**
 *
 * @author Orestis
 */
public class FindLastChar {

  
    public static void main(String[] args) {
    
        StringBuilder str = new StringBuilder("byuerfuorfierfiuredslsfldklshlkdfweydwedalfsdhfjk");
        
        findLastChar(str);
    }
    public static void findLastChar(StringBuilder str){
        int pos=0;
        int result=0;
        
        do{
            pos = str.indexOf("l",pos+1);
            if (pos == -1)
                System.out.println(result);
            else
                result = pos;
        }
        while(pos !=-1);
       
    }
}
