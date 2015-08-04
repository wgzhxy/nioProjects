package org.ssl_tls;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSLServer {
    static int             port = 8266; // ϵͳ��Ҫ�����Ķ˿ں� 
    static SSLServerSocket server;

    public SSLServer() {
    }

    private static SSLServerSocket getServerSocket(int thePort) {
        SSLServerSocket s = null;
        try {
            //String key = "SSLKey";   
            String key = "d:/SSLKey"; // Ҫʹ�õ�֤����  
            char keyStorePass[] = "111111".toCharArray(); // ֤������  
            char keyPassword[] = "111111".toCharArray(); // ֤������ʹ�õ���Ҫ����  

            KeyStore ks = KeyStore.getInstance("JKS"); // ����JKS��Կ��  
            ks.load(new FileInputStream(key), keyStorePass);

            // ��������JKS��Կ���X.509��Կ������  
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, keyPassword);

            // ����SSL������ָ��SSL�汾Ϊ3.0��Ҳ����ʹ��TLSv1������SSLv3���ӳ��á�  
            SSLContext sslContext = SSLContext.getInstance("SSLv3");

            sslContext.init(kmf.getKeyManagers(), null, null);

            // �����������õ�SSL������������SSLServerSocketFactory,��ͨ���Ĳ���������ͬ  
            SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
            s = (SSLServerSocket) factory.createServerSocket(thePort);
        } catch (Exception e) {
            System.out.println(e);
        }
        return (s);
    }

    public static void main(String args[]) {
        try {
            server = getServerSocket(port);
            System.out.println("�ڡ�+port+���˿ڵȴ�����...");
            while (true) {
                SSLSocket socket = (SSLSocket) server.accept();
                // ���õ���socket����CreateThread������, ���̼߳�������  
                new CreateThread(socket);
            }
        } catch (Exception e) {
            System.out.println("main��������80:" + e);
        }
    }
}

class CreateThread extends Thread {
    static BufferedReader in;
    static PrintWriter    out;
    static Socket         s;

    public CreateThread(Socket socket) {
        try {
            s = socket;
            in = new BufferedReader(new InputStreamReader(s.getInputStream(), "gb2312"));
            out = new PrintWriter(s.getOutputStream(), true);
            start(); // �����߳�ִ��run����  
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void run() {
        try {
            String msg = in.readLine();
            System.out.println(msg);
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
