package tencent;

public class Question11 {

    // 面积计算公式 S(i,j) = min(h[i],h[j])*(j-i)

    // 面积是由2部分组成的，j-i2端的时候是最大的，只要移动就会变小
    // a = min(h[i],h[j])
    // 如果向内移动长板，那么面积是一定会减小的
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,max=0;
        while (i<j){
            int temp = Math.min(height[i],height[j]) * (j-i);
            max = Math.max(temp,max);
            if (height[i]>=height[j]){
                j--;
            }else {
                i++;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] temp = {1,8,6,2,5,4,8,3,7};
        new Question11().maxArea(temp);
    }
}
