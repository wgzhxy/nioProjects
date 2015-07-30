package org.wanggz.share.proxy;

import org.wanggz.share.proxy.impl.UserServiceImpl;

/**
 * TODO Comment of ProxyMain
 * 
 * @author guangzhong.wgz
 */
public class ProxyMain {

    public static void main(String args[]) {
        // 实例化目标对象  
        UserService userService = new UserServiceImpl();
        
        // 实例化InvocationHandler  
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        
        // 根据目标对象生成代理对象  
        UserService proxy = (UserService) invocationHandler.getProxy();
        
        // 调用代理对象的方法  
        proxy.add();
    }
}
