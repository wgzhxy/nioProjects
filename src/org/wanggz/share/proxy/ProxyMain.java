package org.wanggz.share.proxy;

import org.wanggz.share.proxy.impl.UserServiceImpl;

/**
 * TODO Comment of ProxyMain
 * 
 * @author guangzhong.wgz
 */
public class ProxyMain {

    public static void main(String args[]) {
        // ʵ����Ŀ�����  
        UserService userService = new UserServiceImpl();
        
        // ʵ����InvocationHandler  
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        
        // ����Ŀ��������ɴ������  
        UserService proxy = (UserService) invocationHandler.getProxy();
        
        // ���ô������ķ���  
        proxy.add();
    }
}
