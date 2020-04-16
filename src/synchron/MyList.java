package synchron;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qindingkang on 2019/4/8.
 */
public class MyList {
    private static List<String> list=new ArrayList<>();

    public static void add(){
        list.add("qdk");
    }

    public static int size(){
        return list.size();
    }
}
