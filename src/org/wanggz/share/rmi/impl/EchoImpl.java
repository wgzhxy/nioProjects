package org.wanggz.share.rmi.impl;

import java.rmi.RemoteException;

import org.wanggz.share.rmi.Echo;

public class EchoImpl implements Echo {

    public String echo(String msg) throws RemoteException {
        return "Echo: " + msg;
    }

}
