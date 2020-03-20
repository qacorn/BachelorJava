package com.class0620;

public class Animal {


    static String name = "猫" ;
    static int id;
    public static void cat(){
        //方法体
    }
    public void dog(){
        System.out.println(Animal.name);
        System.out.println(Animal.id);
        Animal.cat();
    }


//    public static com.class0620.Animal fish(){
//        dog();
//// Non-static method 'dog()' cannot be referenced from a static context
////对象方法要先有对象，通过对象调用对象方法。
//        return this;
////本方法是静态方法，执行当前方法并不需要有Animal对象，而this指代的就是执行当前方法的对象本身，到目前为止，Animal类并没有调用构造方法，没有生成Animal对象，无法返回this。
//
//    }
//
//
//    public static com.class0620.Animal fish(){
//        com.class0620.Animal animal = new com.class0620.Animal();
//        animal.dog();
//        return animal;
//    }

}
