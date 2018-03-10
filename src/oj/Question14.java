package oj;

import java.util.ArrayList;

/**
 * Created by Jvck on 2018/2/19.
 */
public class Question14 {


    public Question14() {

        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

//        int[][] matrix={{1},{2},{3},{4},{5}};

//        int[][] matrix={{1,2},{3,4},{5,6},{7,8},{9,10}};

        ArrayList<Integer> temp=printMatrix(matrix);
        System.out.println(666);

    }

    private ArrayList<Integer> result=new ArrayList<>();
    private int sumNum=0;


    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int row=matrix[0].length;//列
        int col=matrix.length;//行

        boolean symbol=true;
        int num=0;


        for (int i=row,k=col-1;sumNum<row*col;i--){
            if (i==row){
                for (int j=0;j<row;j++){
//                    result.add(matrix[0][j]);
                    num=j;
                    resultAdd(matrix,num,row,col);
                }
            }else {
                if (symbol){//表示为正
                    for (int j=k;j>0;j--){
                        num+=row;
                        resultAdd(matrix,num,row,col);
                    }
                    for (int j=i;j>0;j--){
                        num-=1;
                        resultAdd(matrix,num,row,col);
                    }
                    symbol=false;
                    k-=1;
                }else {
                    for (int j=k;j>0;j--){
                        num-=row;
                        resultAdd(matrix,num,row,col);
                    }
                    for (int j=i;j>0;j--){
                        num+=1;
                        resultAdd(matrix,num,row,col);
                    }
                    symbol=true;
                    k-=1;
                }
            }


        }
        return result;

    }

    public void resultAdd(int [][] matrix,int position,int row,int col){
        int row1=position/row;
        int col1=position%row;
        result.add(matrix[row1][col1]);
        sumNum++;
    }
}
