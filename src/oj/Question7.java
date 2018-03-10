package oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jvck on 2018/2/13.
 */
public class Question7 {

    public Question7() {

        int[] candidates={2,3,6,7};
        combine(candidates, 7);
        System.out.println(123);
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtracking(candidates,target,0,7,list);

        return result;

    }

//    public void backtracking(int n ,int k,int start,List<Integer>list){
//        if (k==0){
//            //这个地方就是判断回溯结束的地方
//            result.add(new ArrayList<>(list));//A
////            result.add(list);//B 因为list是一个地址，添加进去的地址都是一样的，所以结果都一样
//        }else if (k>0){
//           for (int i=start;i<=n;i++){
//               list.add(i);
//               backtracking(n,k-1,i+1,list);
//               list.remove(list.size()-1);
//           }
//        }
//
//    }

    public void backtracking(int[] candidates, int target, int start,int remain, List<Integer> list) {

        if (remain==0){
            result.add(new ArrayList<>(list));
        }else if (remain>0){//remain>0
            for (int i=start;i<candidates.length;i++){
                list.add(candidates[i]);
                backtracking(candidates,target,i,remain-candidates[i],list);//这里执行完第一次后remove
                list.remove(list.size()-1);
            }
        }

    }

    //
//        else if (remain<0){
//            list.remove(list.size()-1);
//
//        }


}
