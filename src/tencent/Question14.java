package tencent;

public class Question14 {

    public String longestCommonPrefix(String[] strs) {

        StringBuilder res = new StringBuilder();
        String firstStr = strs[0];
        for (int i = 0;i<firstStr.length();i++){
            // 第一个字符串就不用比较了
            for (int j = 1; j < strs.length; j++) {
                // 1.当前字符串的值不等，那么直接输出结果
                // 2.当前的字符串的长度大于第一个
                if (strs[j].length()==res.length() || (strs[j].length()>i && strs[j].charAt(i)!=firstStr.charAt(i))){
                    // 就满足条件，可以输出结果了
                    return res.toString();
                }
            }
            res.append(firstStr.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] tem = {"ab","a"};
        new Question14().longestCommonPrefix(tem);
    }


}
