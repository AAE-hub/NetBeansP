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
        // TODO code application logic here
        Random ran = new Random();

        
        Scanner sca = new Scanner(System.in);
        Scanner sca2 = new Scanner(System.in);

        try {
            System.out.println("Enter guessing range");
            int c = sca2.nextInt();
            if (c==0){
                System.out.println("rerun the program and Enter a number more or less than 0");
               exit(1);
            }
            System.out.println("Enter your guess");

            int b = ran.nextInt(c);
            int a = sca.nextInt();
            if (a > b) {
                System.out.println("Enter a number between the range");
            } else if (a < 0) {
                System.out.println("Enter a numver between the range");
            } else if (a == b) {

                System.out.println("correct guess:)");
              
            } else {
                System.out.println(" wrong guess:(");
                  System.out.println("the random number is --->" + b);
            }

        } catch (InputMismatchException n) {
            System.out.println("enter a number  ");
        }
    }

}
