package org.wanggz.share.rmi;

import java.rmi.*;

public class EchoClient {
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            Echo t = (Echo) Naming.lookup("EchoServer");
            for (int i = 0; i < 10; i++) {
                System.out.println(t.echo(String.valueOf(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
