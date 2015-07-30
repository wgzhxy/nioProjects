package org.java.proxy;

import java.net.ServerSocket;
import java.net.Socket;

import org.java.proxy.two.SocketThread;

public class SocketProxy {
	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(8888);
		while (true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				new SocketThread(socket).start();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
