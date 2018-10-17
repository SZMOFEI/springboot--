package com.mofei.map;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mofei
 * @date 2018/10/17 9:29
 */
public class MapTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge("11");
        student.setUserName("wangming");
        Map map = ObjectToMap(student);
        System.out.println(" 学生对象是" +map );


        Map map1= new HashMap();
        map1.put("userName","liming");
        map1.put("age","23");
        Student student1 = (Student) mapToObject(map1, Student.class);
        System.out.println("student1 = " + student1);

    }


    public static Object mapToObject(Map<String, Object> map, Class<?> clazz) {
        Object o = null;
        try {
            o = clazz.newInstance();
            Field[] declaredFields = o.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                int modifiers = field.getModifiers();
                if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(o, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public static Map ObjectToMap(Object o) {
        Map<String, Object> hashMap = new HashMap<String, Object>(16);
        if (null == o) {
            return hashMap;
        }
        Class<?> aClass = o.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                hashMap.put(field.getName(), field.get(o));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}


