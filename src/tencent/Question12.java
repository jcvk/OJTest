package tencent;

public class Question12 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        // 外层的while进行了贪心算法，保证了从大到小进行选择数字
        while (index<13){
            // 里面这个while循环保证了可以重复多次1，但是如果超过3个，也就是4个和5个都是有对应的代替的。
            while (num>=nums[index]){
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new Question12().intToRoman(49);
//        System.out.println("result"+new Question12().test(7));
    }

    public boolean test(int a){
        return (a & (a - 1)) == 0;
    }
}
