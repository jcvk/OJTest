package classloader;

/**
 * Created by qindingkang on 2019/4/8.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader=Test.class.getClassLoader();
        System.out.println(classLoader);
         Class.forName("Test2").newInstance();
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
