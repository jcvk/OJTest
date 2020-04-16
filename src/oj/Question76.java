package oj;


import java.util.HashMap;
import java.util.Objects;

/**
 * Created by qindingkang on 2020/4/8.
 */
public class Question76 {
    public String minWindow(String s, String t) {


        int left = 0, right = 0;

        int start = 0, minLength = Integer.MAX_VALUE;

        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();

        for (Character c : t.toCharArray()) needs.put(c, needs.getOrDefault(c, 0) + 1);

        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            //如果当前的char在need中那么就
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).intValue() == needs.get(c1).intValue()) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (minLength > (right - left)) {
                    minLength = right - left;
                    start = left;
                }
                Character c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    if (window.get(c2) > 1) {//如果大于1，那么就减1
                        window.put(c2, window.get(c2) - 1);
                        if (window.get(c2) < needs.get(c2)) match--;
                    } else {
                        window.remove(c2);//如果只有一个，那么就remove
                        match--;
                    }

                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, minLength + start);

    }

    public void test() {
        String a = "123789123";
        System.out.println(a.substring(0, 1));
        a = "456";
        System.out.println(a.substring(0, 3));
    }

    public static void main(String[] args) {

        String a = "aaaaaaaaaaaabbbbbcdd";
        String b = "abcdd";

        System.out.println(new Question76().minWindow(a, b));
    }
}
