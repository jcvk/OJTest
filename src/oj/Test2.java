package oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Jvck on 2018/3/19.
 */
public class Test2 {

    public static void main(String[] args) {

        new Test2().test();
    }

    private void test(){
        final Student student=new Student(18,"dongbeidaxue");
    }

    class People{
        int age;
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public People(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    class Student extends People{

        private String schoolName;

        public Student(int age,String schoolName) {
            super(age);
            this.schoolName=schoolName;
        }


    }

}
