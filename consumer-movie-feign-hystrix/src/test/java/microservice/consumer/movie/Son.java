package microservice.consumer.movie;

class Parent {
    //父类静态代码块
    static{
        System.out.println("父类静态代码块A");
        //静态属性string_Parent_Static_A是在这个静态代码块的后面定义的，
        //此处不能使用该静态属性，否则会报错。
        //System.out.println(string_Parent_Static_A);
    }
    //父类静态属性
    public static String string_Parent_Static_A = "父类静态属性A";

    //父类无参构造函数
    public Parent(){
        System.out.println("父类无参构造函数");
    }

    //父类静态属性
    public static String string_Parent_Static_B = "父类静态属性B";
    //父类静态代码块
    static{
        System.out.println(string_Parent_Static_A);
        System.out.println("父类静态代码块B");
        System.out.println(string_Parent_Static_B);
    }

    //父类非静态代码块
    {
        System.out.println("父类非静态代码块A");
        //非静态属性string_Parent是在这个非静态代码块后面定义的，此处不能使用string_Parent，
        //否则会报错误：Cannot reference a field before it is defined
        //System.out.println(string_Parent);
    }
    //父类非静态属性
    public String string_Parent = "父类非静态属性";
    //父类非静态代码块
    {
        System.out.println(string_Parent);
        System.out.println("父类非静态代码块B");
    }
}



public class Son extends Parent{
    //子类静态属性
    public static String string_Son_Static = "子类静态属性";
    //子类静态代码块
    static{
        System.out.println(string_Son_Static);
        System.out.println("子类静态代码块");
    }
    //子类无参构造函数
    public Son(){
        System.out.println("子类无参构造函数");
    }
    //子类非静态属性
    public String string_Son = "子类非静态属性";
    //子类非静态代码块
    {
        System.out.println("子类非静态代码块");
    }

    public static void main(String[] args){
        new Son();
    }
}

/*
 * 总结：子类被new的过程中，初始化执行顺序如下：
 * (1)如果子类继承了父类，先执行父类中的静态属性和静态代码块，
 * 静态属性和静态代码块哪一个在前面就先初始化执行哪一个。
 * (2)然后接着执行子类中的静态属性和静态代码块
 * (3)接着执行父类中的非静态属性和非静态代码块，
 * 非静态属性和非静态代码块哪一个在前面就先初始化执行哪一个
 * (4)接着执行父类中的构造函数
 * (5)接着执行子类中的非静态属性和非静态代码块
 * (6)最后执行子类中的构造函数
 * 静态代码块是给静态属性进行初始化的，所以将静态属性放在静态代码块的前面。
 * 同样的，将非静态属性放在非静态代码块的前面。
 * */
