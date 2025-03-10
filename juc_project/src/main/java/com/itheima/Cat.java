package com.itheima;

public class Cat {

    private String name;

    private int age;


    //无参数构造器
    private Cat(){
        this.name = "Tom";
        this.age = 2;
    }


    //有参数构造器
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //成员方法
    public void meow(){
        System.out.println(name + " says: Meow!");
    }

    private String sing(){
        return name + " says: Sing";
    }

    // Getter 和 Setter 方法
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

    @Override
    public String toString() {
        return "Cat{name='" + name + "', age=" + age + "}";
    }
}
