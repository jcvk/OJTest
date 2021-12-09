package tencent;

public class Question8 {

    public int myAtoi(String s) {
        
        int len = s.length();
        // 转换成数组
        char[] chars = s.toCharArray();

        // 出去字符串前面的空格
        int index = 0;
        while (index<len&&chars[index] == ' '){
            index++;
        }
        // 如果s全是空格的情况
        if (index==len){
            return 0;
        }
        // 用来保存
        int sign = 1;
        char signChar = chars[index];
        // 这个index++为什么放在if里面，因为有可能开头没有符号
        if (signChar == '+'){
            index++;
        }else if (signChar == '-'){
            index++;
            sign = -1;
        }
        int res = 0;
        // 遍历然后计算出结果，并且需要进行比较，不能超过int类型的最大长度
        while (index<len){
            char current = chars[index];
            // 如果出现了其他字符，之间返回前面已经计算出的结果res
            if (current>'9'||current<'0'){
                break;
            }

            // 这里不能先比较，因为先比较的res是永远会小于int类型的最大值的
            // 这里需要考虑一个问题，就是到少一位的是，是小于当前的值的，但是在后面需要加上最后一位的时候，
            // 加上去了就大于了int的最大值，所以我们需要在这里做判断
            // 举个例子就是最后一个位的最大值是7 但是我们后面加的值是8 就会超过int的最大值。
            if (res>Integer.MAX_VALUE / 10||(res== Integer.MAX_VALUE/10&&(current-'0')>Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if (res<Integer.MIN_VALUE / 10||(res== Integer.MIN_VALUE/10&&(current-'0')>Integer.MAX_VALUE%10)){
                return Integer.MIN_VALUE;
            }
            // 如果sign是负数，那么就是每次都是负数相加，而不是最后才乘以负数
            res = res*10+sign*(current-'0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Question8().myAtoi("2147483648");
    }
}
