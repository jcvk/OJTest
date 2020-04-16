package oj;

import java.util.HashMap;

/**
 * Created by qindingkang on 2019/3/16.
 */
public class Question819 {

    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map=new HashMap<>();
        for (String str:banned)
            map.put(str,0);
        //把其他的字符都换成空
        paragraph=paragraph.toLowerCase().replaceAll("[^a-z]"," ");
        String[] words = paragraph.split("\\s+");
        int max=1;
        String result="";
        boolean flag=true;
        for (String str:words){
            if (!map.containsKey(str)){//不在ban里
                map.put(str,1);
                if (flag){
                    flag=false;
                    result=str;
                }
            }else if (map.get(str)!=0){//在ban里面
                int times=map.get(str)+1;
                if (times>max){
                    max=times;
                    result=str;
                }
                map.put(str,times);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String paragraph="a.";
        String[] banned={""};
        new Question819().mostCommonWord(paragraph,banned);
    }
}
