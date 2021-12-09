package tencent;

public class Question32 {

    public int longestValidParentheses(String s) {

        char[] sChar = s.toCharArray();
        int length = sChar.length;
        // 从前往后面开始计算
        int max = 0;
        int[] dp = new int[sChar.length];
        for (int i=1;i<length;i++){
            if (sChar[i]==')'){
                if (sChar[i-1]=='('){
                    dp[i]=2;
                    if (i-2>=0){
                        dp[i] = dp[i]+dp[i-2];
                    }
                // 如果前面没有匹配，也没有必要继续往下了
                }else if (dp[i-1]>0){
                    if (i-dp[i-1]-1>=0&&sChar[i-dp[i-1]-1]=='('){
                        dp[i] = dp[i-1] + 2;
                        if (i-dp[i-1]-2>=0){
                            dp[i] = dp[i]+dp[i-dp[i-1]-2];
                        }
                    }
                }

            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        new Question32().longestValidParentheses("(()())");
    }
}
