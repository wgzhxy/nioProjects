package org.wanggz.share.javassis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.CtField.Initializer;

public class JavassistGenerator {

    public static void main(String[] args) throws CannotCompileException,
                                NotFoundException, InstantiationException,
                                IllegalAccessException, ClassNotFoundException,
                                SecurityException, NoSuchMethodException,
                                IllegalArgumentException, InvocationTargetException {
        // ������
        ClassPool pool = ClassPool.getDefault();
        CtClass cls = pool.makeClass("cn.ibm.com.TestClass");

        // ���˽�г�Աname����getter��setter����
        CtField param = new CtField(pool.get("java.lang.String"), "name", cls);
        param.setModifiers(Modifier.PRIVATE);
        cls.addMethod(CtNewMethod.setter("setName", param));
        cls.addMethod(CtNewMethod.getter("getName", param));
        cls.addField(param, Initializer.constant(""));

        // ����޲εĹ�����
        CtConstructor cons = new CtConstructor(new CtClass[] {}, cls);
        cons.setBody("{name = \"Brant\";}");
        cls.addConstructor(cons);

        // ����вεĹ�����
        cons = new CtConstructor(new CtClass[] { pool.get("java.lang.String") }, cls);
        cons.setBody("{$0.name = $1;}");
        cls.addConstructor(cons);

        // ��ӡ�����������
        System.out.println(cls.toClass());

        // ͨ�����䴴���޲ε�ʵ����������getName����
        Object o = Class.forName("cn.ibm.com.TestClass").newInstance();
        Method getter = o.getClass().getMethod("getName");
        System.out.println(getter.invoke(o));

        // ������setName����
        Method setter = o.getClass().getMethod("setName", new Class[] { String.class });
        setter.invoke(o, "Adam");
        System.out.println(getter.invoke(o));

        // ͨ�����䴴���вε�ʵ����������getName����
        o = Class.forName("cn.ibm.com.TestClass").getConstructor(String.class).newInstance("Liu Jian");
        getter = o.getClass().getMethod("getName");
        System.out.println(getter.invoke(o));
    }

}
