package org.wanggz.share.javassis.impl;

import org.wanggz.share.javassis.AbstractDocumentDAO;

/**
 * 具体DocumentDAO类：真实主题角色
 * 
 * @author guangzhong.wgz
 */
public class DocumentDAO implements AbstractDocumentDAO {

    public Boolean deleteDocumentById(String documentId) {
        if (documentId.equalsIgnoreCase("D001")) {
            System.out.println("删除ID为" + documentId + "的文档信息成功！");
            return true;
        } else {
            System.out.println("删除ID为" + documentId + "的文档信息失败！");
            return false;
        }
    }
}
