package org.wanggz.share.cglib;

import org.wanggz.share.cglib.impl.BookFacadeImpl1;

/**
 * TODO Comment of CglibMain
 * 
 * @author guangzhong.wgz
 */
public class CglibMain {

    public static void main(String args[]) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl1 proxy = (BookFacadeImpl1)cglib.getInstance(new BookFacadeImpl1());
        proxy.addBook();
    }
}
