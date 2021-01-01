/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication31;

import static java.lang.System.exit;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 2
 */
public class GuessGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //adding random object 
        Random ran = new Random();

        // scanner to scan the range and the guess from the user 
        Scanner sca = new Scanner(System.in);
        Scanner sca2 = new Scanner(System.in);

        //try for detectin String input 
        try {
            System.out.println("Enter guessing range");
            //entring a guess range
            int c = sca2.nextInt();
            // if the guess = 0 then close the program 
            if (c==0){
                System.out.println("rerun the program and Enter a number more than 0");
               return;
            }else if (c<0){
                System.out.println("range should be more than 0");
                return;
            }
            System.out.println("Enter your guess");
            // entring a random variable 
            int b = ran.nextInt(c);
            //entring the guess
            
            int a = sca.nextInt();
            //function 
            if (a > c) {
                System.out.println("Enter a number between the range");
            } else if (a < 0) {
                System.out.println("Enter a numver between the range");
            } else if (a == b) {

                System.out.println("you won ,correct guess:)");
              
            } else {
                System.out.println(" you lost its a wrong guess:(");
                  System.out.println("the random number is --->" + b);
            }
            //catching input errors
        } catch (InputMismatchException n) {
            System.out.println("enter a number  ");
        }
    }

}
