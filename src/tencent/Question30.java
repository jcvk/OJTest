package tencent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question30 {

    public List<Integer> findSubstring(String s, String[] words) {

        // 最简单有效的办法，就是获取所有的子串，然后进行比较时间复杂度为 n*m

        // 创建2个HashMap用来比较子串
        // 记住这个api map.getOrDefault
        HashMap<String, Integer> a = new HashMap<>();
        for (String word : words) {
            a.put(word, a.getOrDefault(word, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int length = wordLength*words.length;

        int end = s.length()-length;
        for (int i = 0; i < s.length(); i++) {
            int k = i;
            if (i==8){
                System.out.println("123");
            }
            // 判断k的范围
            HashMap<String, Integer> b = new HashMap<>();
            boolean flag = false;
            for (int j = 0; j < words.length && i <= end; j++) {
                String temp = s.substring(k, k + wordLength);
                b.put(temp, b.getOrDefault(temp, 0) + 1);
                if (a.containsKey(temp)&&a.get(temp) >= b.get(temp)) {
                    k += wordLength;
                }else {
                    flag = true;
                    break;
                }
            }
            if (!flag&&i<=end) {
                result.add(i);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String[] temp = {"word","good","best","good"};
        new Question30().findSubstring("wordgoodgoodgoodbestword",temp);
    }
}
