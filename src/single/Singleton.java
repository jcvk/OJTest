package single;

/**
 * Created by Jvck on 2017/12/12.
 */
public class Singleton {

    private static class SingletonHolder{
        private static final Singleton SINGLETON=new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance(){
        return SingletonHolder.SINGLETON;
    }

}
