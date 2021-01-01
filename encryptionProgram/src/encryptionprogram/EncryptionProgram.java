/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionprogram;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 2
 */
public class EncryptionProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the message");

        String plaintxt = scan.nextLine();

        plaintxt = plaintxt.replaceAll(" ", "");

        byte[] byt = plaintxt.getBytes();

        byte[] encByt = new byte[plaintxt.length()];

        for (int i = 0; i < byt.length; i++) {

            encByt[i] = (byte) (byt[i] + 3);

        }

        //bytes number if needed
        /*
         System.out.println(Arrays.toString(byt));
         System.out.println(Arrays.toString(encByt));*/
        //  String str2 = new String(byt);
        String str = new String(encByt);

        // System.out.println("PLAIN TEXT \n"+str2);
        System.out.println("CIPHER TEXT \n" + str);
        
        dec();

    }
public static void dec(){
  Scanner scan = new Scanner(System.in);
        System.out.println("enter the message");

        String plaintxt = scan.nextLine();

        plaintxt = plaintxt.replaceAll(" ", "");

        byte[] byt = plaintxt.getBytes();

        byte[] encByt = new byte[plaintxt.length()];

        for (int i = 0; i < byt.length; i++) {

            encByt[i] = (byte) (byt[i] -3);

        }

        //bytes number if needed
        /*
         System.out.println(Arrays.toString(byt));
         System.out.println(Arrays.toString(encByt));*/
        //  String str2 = new String(byt);
        String str = new String(encByt);

        // System.out.println("PLAIN TEXT \n"+str2);
        System.out.println("CIPHER TEXT \n" + str);


}
}
