/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationprogramserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2
 */
public class CommunicationProgramServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception 
    { 
  
        // Create server Socket 
        ServerSocket ss = new ServerSocket(888); 
  
        // connect it to client socket 
        Socket s = ss.accept(); 
        System.out.println("Connection established"); 
  
        // to send data to the client 
        PrintStream ps 
            = new PrintStream(s.getOutputStream()); 
  
        // to read data coming from the client 
        BufferedReader br 
            = new BufferedReader( 
                new InputStreamReader( 
                    s.getInputStream())); 
  
        // to read data from the keyboard 
        BufferedReader kb 
            = new BufferedReader( 
                new InputStreamReader(System.in)); 
  
        // server executes continuously 
        while (true) { 
  
            String str, str1; 
  
            // repeat as long as the client 
            // does not send a null string 
  
            // read from client 
            while ((str = br.readLine()) != null) { 
                System.out.println(str); 
                str1 = kb.readLine(); 
  
                // send to client 
                ps.println(str1); 
            } 
  
            // close connection 
            ps.close(); 
            br.close(); 
            kb.close(); 
            ss.close(); 
            s.close(); 
  
            // terminate application 
            System.exit(0); 
  
        } // end of while 
    } 
} 