package com.itheima;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Cat> catClass = Cat.class;

        System.out.println("使用class方法获得反射 " + catClass);

        Class<Cat> catClass1 = (Class<Cat>) Class.forName("com.itheima.Cat");

        System.out.println("使用class方法获得反射 " + catClass1);

//        Cat cat = new Cat();
//
//
//        Class<?> catClass2 = cat.getClass();
//
//        System.out.println("使用class方法获得反射 " + catClass2);


        Constructor[] constructors = catClass.getDeclaredConstructors();

        for (Constructor constructor : constructors) {

            System.out.println(constructor);
        }


        Constructor catConstructor = catClass.getDeclaredConstructor();


        catConstructor.setAccessible(true);

        System.out.println("获取具有相关参数的构造器 " + catConstructor);


        Object object = catConstructor.newInstance();

        System.out.println(object.toString());


        Method[] methods = catClass.getDeclaredMethods();

//        for (Method method : methods) {
//            System.out.println(method);
//        }


        Method catMethod = catClass.getDeclaredMethod("sing");

        catMethod.setAccessible(true);

        System.out.println(catMethod);

        catMethod.invoke(object);


        Field[] fields = catClass.getDeclaredFields();

        for (Field field : fields) {

            System.out.println(field);

        }

        Field catField = catClass.getDeclaredField("name");

        catField.setAccessible(true);
        System.out.println(catField);

        catField.set(object, "Garfield");
        System.out.println(catField.get(object));

    }
}
