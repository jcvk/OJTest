package others;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by Jvck on 2018/3/13.
 */
public class Reference {

    private SoftReference<String> softReference;

    public static void main(String[] args) {

        new Reference().weakReference();

    }

    private void strongReference(){
        Object object=new Object();
        Object[] objects1=new Object[40000000];
    }

    private void softReference(){
        String string=new String("456");
        ReferenceQueue queue=new ReferenceQueue();
        softReference=new SoftReference<>(string,queue);
        System.out.println(softReference.get());
    }


    private void weakReference(){

        People people=new People("zhangsan");
        WeakReference<People> weak=new WeakReference<>(people);
        weak.get().getName();
        System.gc();
        weak.get().getName();


    }


    static class People{

        private String name;

        public People(String name) {
            this.name = name;
        }

        public final void getName(){
            System.out.println(name);
        }

        static void fun(){
            System.out.println(123);
        }

        private boolean fun1(){
            System.out.println(798);
            return false;
        }
    }

    static class Student extends People{

        public Student(String name) {
            super(name);
        }

        static void fun(){
            System.out.println(123);
        }






    }


}
