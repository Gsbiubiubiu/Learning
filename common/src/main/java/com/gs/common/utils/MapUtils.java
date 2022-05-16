package com.gs.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @User远
 * @Date2022/4/24
 */
public class MapUtils {

    public static Map<String, Object> create(Object... kvs) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < kvs.length; i += 2) {
            String k = (String) kvs[i];
            Object v = kvs[i + 1];
            if(k != null && v != null){
                map.put(k, v);
            }
        }
        return map;
    }

    public static Map<String, String> createStrValue(String... kvs){
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < kvs.length; i += 2) {
            String k = (String) kvs[i];
            String v = kvs[i + 1];
            if(k != null && v != null){
                map.put(k, v);
            }
        }
        return map;
    }

    public static <T> T map2Bean(Map<String, Object> map, Class<T> clz) throws Exception {
        T obj = clz.newInstance();
        BeanInfo b = Introspector.getBeanInfo(clz, Object.class);
        PropertyDescriptor[] pds = b.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds){
            Method setter = pd.getWriteMethod();
            setter.invoke(obj, map.get(pd.getName()));
        }
        return obj;
    }

    public static Map<String, Object> createEmpty(){
        return new HashMap<>();
    }
}
