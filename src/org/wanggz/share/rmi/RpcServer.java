package org.wanggz.share.rmi;

import java.rmi.*;
import java.rmi.server.*;

public class RpcServer extends UnicastRemoteObject {

    private static final long serialVersionUID = 1L;

    //Ĭ�Ϲ�������ҲҪ��������RemoteExceptionΥ��
    public RpcServer() throws RemoteException {
        super();
    }
    
    public RpcServer(int port) throws RemoteException {
        super(port);
    }

    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            RpcServer es = new RpcServer(8889);
            Naming.rebind("EchoServer", es);
            System.out.println("Ready to provide echo service...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
