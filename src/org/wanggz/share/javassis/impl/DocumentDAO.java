package org.wanggz.share.javassis.impl;

import org.wanggz.share.javassis.AbstractDocumentDAO;

/**
 * ����DocumentDAO�ࣺ��ʵ�����ɫ
 * 
 * @author guangzhong.wgz
 */
public class DocumentDAO implements AbstractDocumentDAO {

    public Boolean deleteDocumentById(String documentId) {
        if (documentId.equalsIgnoreCase("D001")) {
            System.out.println("ɾ��IDΪ" + documentId + "���ĵ���Ϣ�ɹ���");
            return true;
        } else {
            System.out.println("ɾ��IDΪ" + documentId + "���ĵ���Ϣʧ�ܣ�");
            return false;
        }
    }
}
