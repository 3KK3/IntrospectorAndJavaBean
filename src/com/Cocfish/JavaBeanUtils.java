package com.Cocfish;

import java.beans.*;
import java.util.HashMap;
import java.util.Map;

public class JavaBeanUtils {

    public static Map<String, Object> bean2Map(JavaBean bean) throws Exception {

        Map<String, Object> map = new HashMap<>();

        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor item :
                propertyDescriptors) {

            String name = item.getName();
            Object value = item.getReadMethod().invoke(bean);
            map.put(name, value);

        }
        return map;
    }

    public static <T> T map2Bean(Map<String, Object> map, Class<T> beanType) throws Exception {

        Object obj = beanType.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(beanType, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor item :
                pds) {
         String propertyName = item.getName();
         Object value = map.get(propertyName);
         item.getWriteMethod().invoke(obj, value);
        }
        return (T) obj;
    }

}
