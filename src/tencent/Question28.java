package tencent;

public class Question28 {

    public int strStr(String haystack, String needle) {
        // 这里面获取
        if (needle.length()==0) return 0;
        int i;
        for (i=0;i<haystack.length();i++){
            int temp = i;
            int j = 0;
            while (j<needle.length()&&temp<haystack.length()&&haystack.charAt(temp)==needle.charAt(j)){
                temp++;
                j++;
            }
            if (j==needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Question28().strStr("aaa","aaaa")+"");
    }
}
