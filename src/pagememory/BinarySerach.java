package pagememory;

/**
 * Created by Jvck on 2018/3/10.
 */
public class BinarySerach {


    private void binarySerach(int[] array,int key){

        int result=fun(array,0,array.length-1,key);
        if (result==-1){
            System.out.println("error");

        }else {
            System.out.println(result);
        }

    }

    private int fun(int[] array,int left,int right,int key){


        int mid=(right+left)/2;

        if (right<left){
            return -1;
        }

        if (array[mid]==key){
            return mid;
        }else if (array[mid]>key){
            return fun(array,left,mid-1,key);
        }else {
            return fun(array,mid+1,right,key);
        }
    }

    private int fun(int[] array,int key){


        int left=0;
        int right=array.length;
        int mid;

        while (left<=right){

            mid=(left+right)/2;

            if (array[mid]==key){
                return mid;
            }else if (array[mid]>key){
                right=mid-1;
            }else {
                left=mid+1;
            }

        }

        return -1;


    }

    private int fun1(int[] array,int key){


        int left=0;
        int right=array.length;
        int mid;

        while (left<=right){

            mid=(left+right)/2;

            if (array[mid]>=key){
                right=mid-1;
            }else {
                left=mid+1;
            }

        }

        if (left<=array.length&&left>0){
            return left;
        }

        return -1;


    }



    public BinarySerach() {

        int[] array={1,2,2,2,2,2,5,8,8,11,13,13,14,19,20};

//        binarySerach(array,9);
        int result= fun1(array,2);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new BinarySerach();
    }
}
