package com.greatlearning.greatlearningweek7;


import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReflectionsDemo {
    public List<String> textToFile = new ArrayList<>();

    public void getMethods(String className) throws ClassNotFoundException {
        Method[] methods = Class.forName(className).getMethods();
        for(Method method : methods){
            this.textToFile.add(method.getName());
            System.out.println(method.getName());
        }
    }

    public void getClasses(String className){
        Reflections reflections = new Reflections(className);
        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
        for(Object clas : allClasses){
            this.textToFile.add(String.valueOf(clas.toString()));
            System.out.println(clas);
        }
    }

    public void getSubClasses(String className){
        Reflections reflections = new Reflections(className);
        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
        for(Object clas : allClasses){
            this.textToFile.add(String.valueOf(clas.toString()));
            System.out.println(clas);
        }
    }

    public void getParentClasses(String className){
        try {
            Class<?> clas = Class.forName(className);
            Class<?> parent = clas.getSuperclass();
            this.textToFile.add(parent.getName());
            System.out.println(parent.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getConstructors(String className){
        try {
            Class<?> clas = Class.forName(className);
            Constructor<?>[] constructors = clas.getConstructors();
            for(Constructor constructor : constructors) {
                this.textToFile.add(constructor.getName());
                System.out.println(constructor.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getDataMembers(String className){
        try {
            Class<?> clas = Class.forName(className);
            Field[] fields = clas.getDeclaredFields();
            for(Field field : fields) {
                this.textToFile.add(field.getName());
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
