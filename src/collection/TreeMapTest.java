package collection;

import java.util.*;

/**
 * Created by Jvck on 2018/3/13.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(5, "e");
        map.put(1, "a");
        map.put(6, "f");
        map.put(4, "d");
        map.put(2, "b");
        map.put(3, "c");

        /**
         * 通过获得entrySet，然后使用foreach遍历
         */

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        for (Map.Entry<Integer, String> mp : entrySet) {
            String temp = mp.getValue();
            System.out.println(temp);
        }

        /**
         * 通过获得entrySet，然后使用iterator遍历
         */
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> mp = iterator.next();
            String temp = mp.getValue();
            System.out.println(temp);
        }

        /**
         * 通过获取keyset，然后通过foreach遍历
         */

        Set<Integer> set1 = map.keySet();

        System.out.println(00000);

        for (Integer temp :
                set1) {

            System.out.println(map.get(temp));

        }
    }
}
