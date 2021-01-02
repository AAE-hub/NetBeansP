/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationprogram;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;



/**
 *
 * @author 2
 */
public class CommunicationProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception 
    { 
  
        // Create client socket  
        //here type the local host ip or the server 
        //or another device you wnat to connect to
        Socket s = new Socket("192.168.43.126", 888); 
  
        // to send data to the server 
        DataOutputStream dos 
            = new DataOutputStream( 
                s.getOutputStream()); 
  
        // to read data coming from the server 
        BufferedReader br 
            = new BufferedReader( 
                new InputStreamReader( 
                    s.getInputStream())); 
  
        // to read data from the keyboard 
        BufferedReader kb 
            = new BufferedReader( 
                new InputStreamReader(System.in)); 
        String str, str1; 
  
        // repeat as long as exit 
        // is not typed at client 
        while (!(str = kb.readLine()).equals("exit")) { 
  
            // send to the server 
            dos.writeBytes(str + "\n"); 
  
            // receive from the server 
            str1 = br.readLine(); 
  
            System.out.println(str1); 
        } 
  
        // close connection. 
        dos.close(); 
        br.close(); 
        kb.close(); 
        s.close(); 
    } 
} 