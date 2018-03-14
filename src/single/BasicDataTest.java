package single;


/**
 * Created by Jvck on 2018/3/13.
 */
public class BasicDataTest{




    public static void main(String[] args) throws CloneNotSupportedException {

        BasicDataTest test=new BasicDataTest();
        test.test();





    }

    public void test(){
        A a=new A("123");
        System.out.println(a.hashCode());
        A a1=new A("123");
        System.out.println(a1.hashCode());
        System.out.println(a.equals(a1));
        System.out.println(a.hashCode());
        System.out.println(a1.hashCode());

        B b=new B();
        B b1=new B();
        System.out.println(b.hashCode());
        System.out.println(b1.hashCode());





    }

    class A{

        private String id;

        public A(String id){
            this.id=id;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof A){
                A a=(A) obj;
                return (id.equals(a.id));
            }
            return super.equals(obj);//如果没有实现A这个类，那么就调用父类的比较方法
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    class B{

    }







}
