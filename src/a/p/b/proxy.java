/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.p.b;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 */
public class proxy {
    public static void main(String[] args) throws IOException {
        
            
        
  
        String inc;
        
        // proxy
        ServerSocket s = new ServerSocket(8888);
        while (true) {
        //client
        Socket cs = s.accept();
            System.out.println("--------------------------------------------");
            System.out.println("Incoming connection...");
            System.out.println("Peer Info : "+cs.getRemoteSocketAddress());
        Scanner sc = new Scanner(cs.getInputStream());
        inc = sc.nextLine();
        System.out.println("Received from client : "+inc);
        
        //server to forward to
        Socket fs = new Socket("127.0.0.1", 8889); //connect to server
        PrintStream prtS = new PrintStream(fs.getOutputStream());
            System.out.println("Sending data to server");
        prtS.println("He said " + inc);          // send data to server
            System.out.println("Receiving data from server");
        Scanner sc2 = new Scanner(fs.getInputStream());     // receive data from server
            String result = sc2.nextLine();
            System.out.println("Sending data back to client");
        PrintStream prtC = new PrintStream(cs.getOutputStream());
        
        prtC.println(result);          // returns data to client
        
        cs.close();
        fs.close();
        prtS.close();
        prtC.close();
        
      }
        
        
        
        
        
        
        
        
        
    }
}
