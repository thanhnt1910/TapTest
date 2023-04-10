package com.tap.exam.util;

import com.tap.exam.model.Division;
import com.tap.exam.model.Science;

import java.lang.reflect.Field;

public class DivisionReflection {
    public static Object setClassInfo(String className, String data, Object object) {
       try {
           String[] str = data.split("\\s+");
           int index = 1;
           //Get the class by name
           Class aClass = Class.forName(className);
           //Get all private file
           Field[] fields = aClass.getSuperclass().getSuperclass().getDeclaredFields();
           //Set data for each field
           for (Field field : fields) {
               int value = Integer.parseInt(str[index]);
               field.setAccessible(true);
               field.set(object, value);
               index++;
           }
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IllegalAccessException e) {
           throw new RuntimeException(e);
       }
        return object;
    }
}
