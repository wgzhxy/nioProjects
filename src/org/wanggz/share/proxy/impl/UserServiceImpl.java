package org.wanggz.share.proxy.impl;

import org.wanggz.share.proxy.UserService;

/**
 * Ŀ�����
 * 
 * @since 2012-8-9
 */
public class UserServiceImpl implements UserService {

    /*
     * (non-Javadoc)
     * @see dynamic.proxy.UserService#add()
     */
    public void add() {
        System.out.println("--------------------add---------------");
    }
}
