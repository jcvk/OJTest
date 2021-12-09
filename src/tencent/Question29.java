package tencent;

public class Question29 {

    public int divide(int dividend, int divisor) {

        if (dividend==0) return 0;
        if (divisor == 1) return dividend;
        // 考虑int越界的情况，因为int的取值范围是 -2^31~2^31-1的范围如果 dividend = -2^31 取反会超过Int的最大值
        if (divisor == -1){
            if (dividend>Integer.MIN_VALUE){
                return -dividend;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        int sign = 1;
        // 判断运算结果的符号
        if ((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
            sign = -1;
        }
        long a = dividend;
        long b = divisor;
        a = a>0?a:-a;
        b = b>0?b:-b;
        int res = divi(a,b);
        if (sign>0){
            return res;
        }else {
            return -res;
        }


    }

    private int divi(long dividend, long divisor){
        if (dividend<divisor){
            return 0;
        }
        int count = 1;
        // 这里需要用long 因为2哥divisor相加的时候，int会溢出
        long temp = divisor;
        while (temp+temp<dividend){
            count+=count;
            temp+=temp;
        }
        return count + divi(dividend-temp,divisor);
    }

    public static void main(String[] args) {
        new Question29().divide(-2147483648,-1);
    }
}
