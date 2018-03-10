package thread;

/**
 * Created by Jvck on 2018/1/30.
 */
public class Test {

    public static Test SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("yes,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method is executed!");
        Test.SAVE_HOOK=this;//这里new Test产生的对象快要死了，然后绑定到gc roots的静态变量上去，达到拯救的目的
        //只要SAVE_HOOK这个静态的引用存在，那么被引用的这个对象就不会被gc，因为和gc roots有关联
    }


    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new Test();//这里的回收的对象是new Test这个对象。而不是回收的SAVE_HOOK这个对象
        SAVE_HOOK=null;
        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no i am dead");
        }

        SAVE_HOOK=null;
        System.gc();

        Thread.sleep(500);

        if (SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no i am dead");
        }
    }
}
