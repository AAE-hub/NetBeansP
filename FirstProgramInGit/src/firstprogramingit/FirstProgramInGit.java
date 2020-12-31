/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprogramingit;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 2
 */
public class FirstProgramInGit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       try{
        System.out.println("Enter a Number from 1 to 7 ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
        if (num <= 7 && num >=1){
        switch (num) {
            case 1:
                System.out.print("Monday \n");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            
        }

    }
        else 
            System.out.println("you entered a wrong number \n"+" rerun the program");
        
    }
     catch(InputMismatchException b){
            System.out.println("enter a number please ");
}
    
    }
   
    

}
