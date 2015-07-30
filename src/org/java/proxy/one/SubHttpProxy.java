package org.java.proxy.one;

// HttpProxy�ļ�������
// ����¼��������
// ����־�����ÿһ��ǰ�����һ��'*'

import java.io.*;
import java.net.*;

public class SubHttpProxy extends HttpProxy {

    static private boolean first = true;

    public SubHttpProxy(Socket s) {
        super(s);
    }

    public void writeLog(int c, boolean browser) throws IOException {
        if (first)
            log.write('*');
        first = false;
        log.write(c);
        if (c == '\n')
            log.write('*');
    }

    public String processHostName(String url, String host, int port, Socket sock) {
        // ֱ�ӷ���
        return host;
    }

    // �����õļ�main����
    static public void main(String args[]) {
        System.out.println("�ڶ˿�808�������������\n");
        HttpProxy.log = System.out;
        HttpProxy.logging = true;
        HttpProxy.startProxy(808, SubHttpProxy.class);
    }

}
