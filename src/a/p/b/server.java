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
public class server {
    
    public static void main(String[] args) throws IOException {
        
        
        String out = "Good Evening Crypto";
                
        ServerSocket s = new ServerSocket(8889);
        while (true) {
        Socket ps = s.accept();
        
        PrintStream prt = new PrintStream(ps.getOutputStream());
        prt.println(out);
        
        
        prt.close();
        ps.close();
        }

    }
}
