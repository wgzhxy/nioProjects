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
    static int             port = 8266; // 系统将要监听的端口号 
    static SSLServerSocket server;

    public SSLServer() {
    }

    private static SSLServerSocket getServerSocket(int thePort) {
        SSLServerSocket s = null;
        try {
            //String key = "SSLKey";   
            String key = "d:/SSLKey"; // 要使用的证书名  
            char keyStorePass[] = "111111".toCharArray(); // 证书密码  
            char keyPassword[] = "111111".toCharArray(); // 证书别称所使用的主要密码  

            KeyStore ks = KeyStore.getInstance("JKS"); // 创建JKS密钥库  
            ks.load(new FileInputStream(key), keyStorePass);

            // 创建管理JKS密钥库的X.509密钥管理器  
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, keyPassword);

            // 构造SSL环境，指定SSL版本为3.0，也可以使用TLSv1，但是SSLv3更加常用。  
            SSLContext sslContext = SSLContext.getInstance("SSLv3");

            sslContext.init(kmf.getKeyManagers(), null, null);

            // 根据上面配置的SSL上下文来产生SSLServerSocketFactory,与通常的产生方法不同  
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
            System.out.println("在”+port+”端口等待连接...");
            while (true) {
                SSLSocket socket = (SSLSocket) server.accept();
                // 将得到的socket交给CreateThread对象处理, 主线程继续监听  
                new CreateThread(socket);
            }
        } catch (Exception e) {
            System.out.println("main方法错误80:" + e);
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
            start(); // 开新线程执行run方法  
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
