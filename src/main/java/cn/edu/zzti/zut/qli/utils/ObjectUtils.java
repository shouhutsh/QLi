package cn.edu.zzti.zut.qli.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ObjectUtils {

    public static Class<?>[] getInnerClasses(Class<?> clz) {
        Class<?>[] innerClasses = clz.getClasses();
        if (innerClasses == null) {
            return null;
        }

        List<Class<?>> result = new ArrayList<>();
        result.addAll(Arrays.asList(innerClasses));
        for (Class<?> inner : innerClasses) {
            Class<?>[] innerClz = getInnerClasses(inner);
            if (innerClz == null) {
                continue;
            }

            result.addAll(Arrays.asList(innerClz));
        }

        return result.toArray(new Class<?>[0]);
    }

    /**
     * 获取该类本身所有字段
     * @param clazz
     * @return
     */
    public static List<Field> getDeclaredFields(Class clazz) {
        return getDeclaredFields(clazz, (field) -> true);
    }

    /**
     * 通过 FieldFilter 函数获取该类本身字段
     * @param clazz
     * @param filter
     * @return
     */
    public static List<Field> getDeclaredFields(Class clazz, FieldFilter filter) {
        List<Field> fields = new ArrayList<>();
        for (Field f : clazz.getDeclaredFields()) {
            if(filter.isAccess(f)){
                fields.add(f);
            }
        }
        return fields;
    }

    /**
     * 获取该类及父类所有字段
     * @param clazz
     * @return
     */
    public static List<Field> getAllFields(Class clazz) {
        return getAllFields(clazz, (field) -> true);
    }

    /**
     * 通过 FieldFilter 函数获取该类本身及父类字段
     * @param clazz
     * @param filter
     * @return
     */
    public static List<Field> getAllFields(Class clazz, FieldFilter filter) {
        List<Field> fields = new ArrayList<>();
        Class temp = clazz;
        while (temp != Object.class) {
            for (Field f : temp.getDeclaredFields()) {
                if (filter.isAccess(f)) {
                    fields.add(f);
                }
            }
            temp = temp.getSuperclass();
        }
        return fields;
    }

    public interface FieldFilter{
        boolean isAccess(Field field);
    }
}
