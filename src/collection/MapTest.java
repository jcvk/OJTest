package collection;


import java.util.*;

/**
 * Created by Jvck on 2018/3/14.
 */
public class MapTest {

    public static void main(String[] args) throws InterruptedException {

        //WeakHashMap gc测试
//        WeakHashMap wake=new WeakHashMap();
//
//        wake.put(new ClassA("数学"),new ClassB(90));
//        wake.put(new ClassA("语文"),new ClassB(80));
//
//        wake.put("java",100);
//
//        System.out.println(wake);
//
//        System.gc();
//        System.runFinalization();
//        System.out.println(wake);

        //HashTable同步测试
//        new MapTest().thredMapTest();

        //存放为空值测试
//        new MapTest().nullTest();

        //LinkedHashMap的打印顺序
        new MapTest().linkedHashMapTest();

    }

    static class ClassA{
        String name;

        public ClassA(String name) {
            this.name = name;
        }

    }

    static class ClassB{
        public int gread;

        public ClassB(int gread) {
            this.gread = gread;
        }
    }

    private void thredMapTest() throws InterruptedException {

//        ConcurrentHashMap hashMap=new ConcurrentHashMap();

        HashMap<ClassA,ClassB> hashMap=new HashMap<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<500;i++){
                    hashMap.put(new ClassA(""+i),new ClassB(i));
                    System.out.println("hashMap的长度"+hashMap.size());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

//                for (int i=0;i<100;i++){
//                    System.out.println(Thread.currentThread().getId()+"  "+i);
//                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    while (!hashMap.isEmpty()){
                        Set<Map.Entry<ClassA,ClassB>> set=hashMap.entrySet();
                        for (Map.Entry<ClassA,ClassB> mp:set){
                            System.out.println("遍历的分数 "+mp.getValue().gread);
                            if (mp.getKey().name.equals(1)){
                                hashMap.remove(mp.getKey());
                            }
                        }
                        hashMap.clear();
                    }


                }

            }
        }).start();
    }

    private void nullTest(){

        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put(null,null);
        Hashtable<String,Integer> hashtable=new Hashtable<>();
        hashtable.put(null,null);
    }

    private void linkedHashMapTest(){
        HashMap<String,Integer> hashMap=new HashMap<>();

        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);
        hashMap.put("4",4);
        hashMap.put("5",5);
        hashMap.put("6",6);
        hashMap.put("7",6);

        Set<Map.Entry<String,Integer>> entrySet=hashMap.entrySet();

        Iterator<Map.Entry<String,Integer>> lterator=entrySet.iterator();

        while (lterator.hasNext()){
            Map.Entry<String,Integer> temp=lterator.next();
            System.out.println(temp.getValue());
        }

    }
}
