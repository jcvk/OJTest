package collection;

import java.util.*;

/**
 * Created by Jvck on 2018/3/13.
 */
public class TreeMapTest  {

    public static void main(String[] args) {
        TreeMap<Integer,String> map=new TreeMap<>();

        map.put(5,"e");
        map.put(1,"a");
        map.put(6,"f");
        map.put(4,"d");
        map.put(2,"b");
        map.put(3,"c");




        Set<Map.Entry<Integer,String>> entrySet=map.entrySet();

        for (Map.Entry<Integer, String> mp : entrySet) {
            String temp = mp.getValue();
            System.out.println(temp);
        }
    }
}
