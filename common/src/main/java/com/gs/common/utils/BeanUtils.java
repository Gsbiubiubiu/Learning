package com.gs.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.BiFunction;

/**
 * @User远
 * @Date2022/4/18
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils{

    public static <E, T> List<T> copyProps(List<E> origList, Class<T> destCls) throws Exception {
        return copyProps(origList, destCls, null);
    }

    public static <E, T> List<T> copyProps(List<E> origList, Class<T> destCls,
                                           BiFunction<? super E, ? super T, ? extends T> fillerFunction) throws Exception {
        if(origList == null){
            return null;
        }
        List<T> destList = new ArrayList<>();
        for (E e : origList) {
            T dest = copyProps(e, destCls);
            if(fillerFunction != null){
                dest = fillerFunction.apply(e, dest);
            }
            destList.add(dest);
        }
        return destList;
    }

    public static <T> T copyProps(Object obj, Class<T> cls) throws Exception {
        if(obj == null){
            return null;
        }
        T dto = cls.getConstructor().newInstance();
        copyProperties(dto, obj);
        return dto;
    }

    public static Map<String, Object> extractProps(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = getAllFields(obj);
        for(Field f : fields){
            int mod = f.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }
            if(Modifier.isPrivate(mod) || Modifier.isProtected(mod)){
                f.setAccessible(true);
            }
            Object v = f.get(obj);
            map.put(f.getName(), v);
        }
        return map;
    }

    //TODO
    private static Field[] getAllFields(Object obj) {
        Class clazz = obj.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
