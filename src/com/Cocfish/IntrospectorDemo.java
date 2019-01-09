package com.Cocfish;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.SocketOption;

public class IntrospectorDemo {

    public static void main(String[] args) throws Exception {

        BeanInfo info = Introspector.getBeanInfo(User.class);
        // 获取JavaBean对象的所有属性描述器
        PropertyDescriptor[] props = info.getPropertyDescriptors();

        for (PropertyDescriptor item : props) {
            // 获取名称
            String propName = item.getName();
            // 获取类型
            Class type = item.getPropertyType();
            System.out.println(propName + type);

            // 获取getter、 setter方法
            Method getter = item.getReadMethod();
            Method setter = item.getWriteMethod();
            System.out.println("getter:"+ getter);
            System.out.println("setter:"+ setter);
            System.out.println("-------------");
        }
    }
}
