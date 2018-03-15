package others;

/**
 * Created by Jvck on 2018/3/14.
 */
public class TryCatchTest {

    public static void main(String[] args) {

        TryCatchTest test=new TryCatchTest();
        int[] array={1,2,3,4,5,6,7};
        test.reOrderArray(array);
        System.out.println(666);

    }

    public void reOrderArray(int [] array) {

        int temp;
        int len=array.length;
        for(int i=0,j=0;i<len;i++){
            if(array[i]%2==1){
                temp=array[i];
                for(int k=i;k>j;k--){
                    array[k]=array[k-1];
                }
                array[j]=temp;
                j++;
                break;
            }
        }

    }
}
