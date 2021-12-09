package tencent;

public class Question5 {

    public String longestPalindrome(String s) {
        int len = s.length();
        // 单个的字母就是回文
        if (len<2){
            return s;
        }
        int begin = 0;
        int maxLen = 1;
        // 创建保存状态二维数组
        boolean[][] dp = new boolean[len][len];
        // 初始化数组,所有单个的数组元素都是回文
        for (int i=0;i<len;i++){
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 这个L是子串的长度，为什么从2开始，因为是1的情况已经在上面初始化了
        for (int L = 2;L<=len;L++){
            for (int i=0;i<len;i++){
                // 由子串的长度和左边界，就可以确定有边界
                int j = L+i-1;
                if (j>=len){
                    break;
                }
                if (charArray[i]!=charArray[j]){
                    dp[i][j] = false;
                }else {
                    if (j-i<3){
                        // 这种情况是这个子串只有2个长度，在前面已经判断过了，就是charArray[i]是等于charArray[j]，所以直接为true
                        dp[i][j] = true;
                    }else {
                        // 其他的情况就是等于里面第二长的子串的结果
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j]&&L>maxLen){
                    maxLen = L;
                    // 这里保存begin主要是后面输出子串的位置
                    begin = i;
                }

            }
        }
        return s.substring(begin,begin+maxLen);

    }
}
