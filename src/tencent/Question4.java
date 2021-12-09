package tencent;

public class Question4 {

    // 时间复杂度为 O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        // 这个left用来保存如果是偶数的情况
        int left = 0;
        int right = 0;
        int nStart = 0;
        int mStart = 0;
        int length = n+m;
        for (int i=0;i<=length/2;i++){
            left = right;
            if (nStart<n&&(mStart>=m||nums1[nStart]<nums2[mStart])){
                right = nums1[nStart++];
            }else {
                right = nums2[mStart++];
            }
        }
        if ((length&1)==0){
            return (left+right)/2.0;
        }else {
            return right;
        }


    }

    // 时间复杂度为 (O)log(m+n)
    // 主要的思路就是 int temp = k/2
    // 比较两个数组temp位置上的大小，小的一个数组，直接去掉左边的
    // 然后比较 temp = (k-temp)/2
    // 知道temp=1的时候，返回中位数
    public double findMedianSortedArraysA(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n+m+1)/2;
        int right = (n+m+2)/2;
        return (getKth(nums1,0,n-1,nums2,0,m-1,left)+getKth(nums1,0,n-1,nums2,0,m-1,right))*0.5;
    }

    // 这个递归end的数值是不会变的，但是start的数值是会变的
    private int getKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1 - start1 +1;
        int len2 = end2 - start2 +1;

        if (k==1) return Math.min(nums1[start1],nums2[start2]);

        // 这里Math.min的目的是为了避免寻找k/2的时候，长度超过了还剩的数组的长度
        int i = start1 + Math.min(len1,k/2) -1;
        int j = start2 + Math.min(len2,k/2) -1;

        if (nums1[i]>nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }else {
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(j-start2+1));
        }
    }
}
