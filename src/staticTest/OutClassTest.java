package staticTest;

/**
 * Created by qindingkang on 2019/2/28.
 */
public class OutClassTest {

    int out1 = 1;
    static int out2 = 1;

    static void out() {
        System.out.println("非静态");
    }

    //这里是外部类
    static void outstatic() {
        System.out.println("静态");
        InnerstaticClass.innerstatic();//外部类可以访问静态内部类的静态方法，非静态方法，只能创建对象后访问
    }

    public class InnerClass {
        void InnerClass() {
            System.out.println("InnerClass!");
            System.out.println(out1);
            System.out.println(out2);
            out();
            outstatic();//静态内部类只能够访问外部类的静态成员
        }

        // static void inner(){}  static int i=1; 非静态内部类不能有静态成员（方法、属性）
    }

    public static class InnerstaticClass {
        private void InnerstaticClass() {
            System.out.println("InnerstaticClass");
            //  System.out.println(out1);out(); 静态内部类只能够访问外部类的静态成员
            System.out.println(out2);
            outstatic();
        }

        static private void innerstatic() {
            out();
        }

        static int i = 1;//静态内部类能有静态成员（方法、属性）
    }

    public static void main(String args[]) {
        OutClassTest a = new OutClassTest();
        InnerstaticClass.innerstatic();
        OutClassTest.InnerstaticClass b = new OutClassTest.InnerstaticClass();//创建静态内部类
        OutClassTest.InnerClass c = a.new InnerClass();//创建非静态内部类
    }


}
