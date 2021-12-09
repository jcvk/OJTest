package tencent;

public class Question7 {

    // 这里int是32位有符号整数，所以还需要有一位用来保存符号，所以一共是2^31-1 -2^31
    // 加入有1147483649这个数字，如果反转过来那就是9463847411 比32位整数还要大，这样
    // 的数字是没法存到int里面的，所以要返回0
    public int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断整数溢出
            if (res>214748364){
                return 0;
            }
            if (res<-214748364){
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;

    }

    public static void main(String[] args) {
        int x = 1147483649;
        new Question7().reverse(x);
    }
}
