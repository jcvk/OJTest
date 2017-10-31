/**
 * Created by lenovo on 2017/10/26.
 */
public class Question1 {

    public Question1() {
    }

    public boolean find(int target,int[][] array){
        for (int[] anArray : array) {
            if (fastFind(target, anArray) != -1) {
                return true;
            }
        }

        return false;
    }

    private int fastFind(int target,int[] array){

        int length=array.length;
        int top=length-1;
        int bottom=0;
        int middleData=length/2;
        while (array[middleData]!=target){
            if (array[middleData]>target){
                top=middleData-1;
            }else {
                bottom=middleData+1;
            }

            if (top==bottom){
                if (array[top]==target){
                    return middleData;
                }else {
                    return -1;
                }
            }else {
                middleData=(top-bottom)/2;
            }
        }

        if (middleData<0){
            return -1;
        }else {
            return middleData;
        }

    }
}
