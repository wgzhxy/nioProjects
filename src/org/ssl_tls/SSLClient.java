package org.ssl_tls;

import java.io.PrintWriter;
import java.net.Socket;

import javax.net.ssl.SSLSocketFactory;

public class SSLClient {
    
    static int port = 8266;

    public static void main(String args[]) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            Socket s = factory.createSocket("127.0.0.1", port);

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("安全的说你好");
            out.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
