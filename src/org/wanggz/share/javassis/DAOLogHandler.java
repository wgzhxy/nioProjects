package org.wanggz.share.javassis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * �Զ��������������
 * 
 * @author guangzhong.wgz
 */
class DAOLogHandler implements InvocationHandler {

    private Calendar calendar;
    private Object   object;

    public DAOLogHandler() {
    }

    //�Զ����вι��캯��������ע��һ����Ҫ�ṩ�������ʵ�������  
    public DAOLogHandler(Object object) {
        this.object = object;
    }

    //ʵ��invoke()��������������ʵ�������ж���ķ���  
    @SuppressWarnings("unused")
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        Object result = method.invoke(object, args); //ת������  
        afterInvoke();
        return null;
    }

    //��¼��������ʱ��  
    public void beforeInvoke() {
        calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String time = hour + ":" + minute + ":" + second;
        System.out.println("����ʱ�䣺" + time);
    }

    public void afterInvoke() {
        System.out.println("�������ý�����");
    }
}
