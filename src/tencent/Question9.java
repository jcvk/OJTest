package tencent;

public class Question9 {

    //暴力解决法，int类型，转换为数组，然后将数组进行反转，比较数组
    public boolean isPalindrome(int x) {

        // 如何把数字倒过来，然后比较2个数字的大小就可以了
        int revers  = 0;
        int temp = x;
        while (temp>0){
            int a = temp%10;
            revers = revers * 10+a;
            temp = temp/10;
        }
        return revers == x;
    }

    // 进阶实现方式 只需要比较int类型一般的大小
    public boolean isPalindromeA(int x){

        // 负数排除，如果最后一个数字为0，并且x不为0也可以去除
        if (x<0||(x%10==0&&x!=0)){
            return false;
        }
        int revers = 0;
        while (x>revers){
            revers = revers*10+x%10;
            x /= 10;
        }
        // 考虑奇偶数的问题
        return x==revers||x==revers/10;
    }

    public static void main(String[] args) {
        new Question9().isPalindrome(123);
    }
}
