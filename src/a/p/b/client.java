/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.p.b;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 */
public class client {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println("Establishing connection..");
        Socket s = new Socket("127.0.0.1", 8888);
        System.out.println("Connection established!");
        PrintStream prt = new PrintStream(s.getOutputStream());
        String result;
        
        
        prt.println("Good Morning Crypto");
        System.out.println("Message transfered");
        
        Scanner sc = new Scanner(s.getInputStream());
        result = sc.nextLine();
        System.out.println(result);
        
        sc.close();
        prt.close();
        

    }
}
