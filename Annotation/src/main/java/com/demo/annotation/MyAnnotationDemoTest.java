package com.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyAnnotationDemoTest {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.demo.annotation.MyAnnotationDemo");
        // printClassInfo(clazz);
        Method[] methods = clazz.getMethods();
        printMethodInfo(clazz, methods);
    }

    private static void printMethodInfo(Class<?> clazz, Method[] methods) throws Exception {
        System.out.println("\n************* call printMethodInfo begin ************* ");
        for (Method method : methods) {
            // 判断方法是否有指定的注解信息
            boolean annotationPresent = method.isAnnotationPresent(MyAnnotation.class);
            if (annotationPresent) {
                System.out.println(method.getName());

                // call print()
                method.invoke(clazz.getConstructor().newInstance(null), null);
                method.invoke(clazz.newInstance(), null);

                // print注解信息
                for (Annotation annotation : method.getAnnotations()) {
                    System.out.println("method annotation: " + annotation.toString());
                }
            }
        }
        System.out.println("************* call printMethodInfo end ************* \n");
    }

    private static void printClassInfo(Class<?> clazz) {
        System.out.println("************* call printClassInfo begin************* ");

        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println("class annotation name: " + annotation.toString());
        }

        System.out.println("class CanonicalName: " + clazz.getCanonicalName());

        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println("class constructor name: " + constructor.getName());
        }

        System.out.println("************* call printClassInfo end************* ");
    }
}
