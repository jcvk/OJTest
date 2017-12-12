package oj;

/**
 * Created by lenovo on 2017/10/26.
 */
public class Question1 {

    public Question1() {
    }

    public boolean find(int target,int[][] array){


        if (array.length!=0&&array[0]!=null){

            for (int[] anArray : array) {
                if (fastFind(target, anArray) != -1) {
                    return true;
                }
            }

        }



        return false;
    }

    private int fastFind(int target,int[] array){

        int length=array.length;
        int top=length-1;
        int bottom=0;
        int middleData=length/2;
        if (middleData<0||middleData>array.length-1){
            return -1;
        }
        while (array[middleData]!=target){


            if (array[middleData]>target){
                top=middleData-1;
            }else {
                bottom=middleData+1;
            }
            if (bottom>top){
                return -1;
            }else {
                middleData=(top-bottom)/2+bottom;
            }

        }
        return 1;
    }
}
