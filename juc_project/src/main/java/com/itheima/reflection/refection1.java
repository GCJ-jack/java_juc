package com.itheima.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class refection1 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //方法1通过class路径
        Class class1 = Class.forName("com.itheima.reflection.Student");

        Class class2 = Student.class;

        Student student = new Student("chaojun",22,"male");


        Class class3 = student.getClass();

        System.out.println(class2);

//        获取成员变量
//        getFields()//获取所有公开的成员变量,包括继承变量
//
//        getDeclaredFields()//获取本类定义的成员变量,包括私有,但不包括继承的变量
//
//        getField(变量名)//获取指定公共属性的Field对象
//
//        getDeclaredField(变量名)//获取指定包括私有,不包括继承的Field对象

        Field[] fieldList = class1.getFields();

        Field[] fieldList2 = class2.getDeclaredFields();

        Field field = class3.getField("gender");

        Field declaredField = class3.getDeclaredField("name");

        System.out.println(field);

        System.out.println(declaredField);

//        获取成员方法
//        getMethods()//获取所有可见的方法,包括继承的方法
//        getMethod(方法名,参数类型列表)//获取指定方法的Method对象
//        getDeclaredMethods()//获取本类定义的的方法,包括私有,不包括继承的方法
//        getDeclaredMethod(方法名,int.class,String.class)//获取指定包括私有,不包括继承的Method对象

        Method[] methodList = class1.getMethods();

        Method method = class2.getMethod("getName");

        Method[] declaredMethod = class2.getDeclaredMethods();

        Method declaredMethod2 = class1.getDeclaredMethod("getName");

        for (Method method1 : declaredMethod) {
            System.out.println(method1);
        }

        System.out.println(declaredMethod2);
//
//        Class class4 = Student.class;
    }
}


class Student{
    private String name;
    private int age;
    public String gender;


    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;

    }
}
