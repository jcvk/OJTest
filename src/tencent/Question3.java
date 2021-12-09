package tencent;

import java.util.HashMap;

public class Question3 {

    public int lengthOfLongestSubstring(String s) {

        //创建一个hashMap来存放字符串的位置
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0,max = 0;
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                // 这里加上Math.max 主要是为了考虑 abba 这种情况，当到第二个a的时候，去map里面查找，会找到第一个a，那么
                // 这个时候left是2,单身map.get(s.charAt(i))+1 获取到的是1，那么实际情况我们应该选2，所以需要选取最大值
                left = Math.max(left,map.get(s.charAt(i))+1) ;
            }
            max = Math.max(max,i-left+1);
            map.put(s.charAt(i),i);
        }
        return max;
    }


    public static void main(String[] args) {
        new Question3().lengthOfLongestSubstring("abba");
    }
}
