package morecode;



/**
 * Created by qindingkang on 2019/10/21.
 */
public class Fanxing {

    public class Gener<T>{

        private T key;

        public Gener(T key){
            this.key= key;
        }

        public T getKey(){
            return key;
        }

        public <E> void fun3(E obj){

        }

    }

    public static void main(String[] args) {
        new Fanxing().fun1();

    }

    public  void fun(){
        Gener gener1=new Gener("123");
        Gener gener2=new Gener(234);
        Gener gener3=new Gener(false);

        System.out.println(gener1.getKey());
        System.out.println(gener2.getKey());
        System.out.println(gener3.getKey());
    }

    public void fun1(){
        Gener<Integer> gener = new Gener<>(123);
        Gener<Number> gener1=new Gener<>(456);
        show(gener1);
        show(gener);
    }

    public void show(Gener<?> obj){
        System.out.println(obj.getKey());
    }

    //泛型方法
    public <T> T showKeyName(Gener<T> container){
        System.out.println(container.getKey());
        return container.getKey();
    }
}
