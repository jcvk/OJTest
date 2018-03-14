package algorithm;

/**
 * Created by Jvck on 2018/3/10.
 */
public class QuickSort {

    private void quickSort(int[] array, int left, int right){

        if (left>=right) return;

        int l=left;
        int r=right;
        int key=array[left];

        while (left<right){
            while (left<right&&array[right]>key) right--;
            array[left]=array[right];
            while (left<right&&array[left]<=key) left++;
            array[right]=array[left];

            for (int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println("");
        }

        array[left]=key;
        quickSort(array,l,left-1);
        quickSort(array,left+1,r);
    }

    public static void main(String[] args) {
        new QuickSort();
    }

    public QuickSort() {

        int[] test={7,8,5,9,4,8,3,3,1};
        quickSort(test,0,test.length-1);
        System.out.println(666);

    }
}
