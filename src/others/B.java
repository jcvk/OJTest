package others;

/**
 * Created by qindingkang on 2018/5/9.
 */
public class B extends A {
    public void d(){

    }
    private void test(){
        A a=new A();
        B b=new B();
        ((B)a).d();

    }
}
