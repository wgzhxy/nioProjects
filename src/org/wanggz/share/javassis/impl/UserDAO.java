package org.wanggz.share.javassis.impl;

import org.wanggz.share.javassis.AbstractUserDAO;

/**
 * //����UserDAO�ࣺ��ʵ�����ɫ
 * 
 * @author guangzhong.wgz
 */
public class UserDAO implements AbstractUserDAO {

    public Boolean findUserById(String userId) {
        if (userId.equalsIgnoreCase("���޼�")) {
            System.out.println("��ѯIDΪ" + userId + "���û���Ϣ�ɹ���");
            return true;
        }
        else {
            System.out.println("��ѯIDΪ" + userId + "���û���Ϣʧ�ܣ�");
            return false;
        }
    }
}
