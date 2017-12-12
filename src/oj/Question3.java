package oj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jvck on 2017/11/15.
 */
public class Question3 {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val=x;}

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        HashMap inMap=new HashMap();

        for(int i=0;i<in.length;i++){
            inMap.put(in[i],i);
        }

        int topPosition=0;
        //通过前序遍历来创建二叉树
        for (int i=0;i<pre.length;i++){

            topPosition=(int)inMap.get(pre[i]);//得到头节点
            TreeNode topNode=new TreeNode(pre[i]);

            StringBuffer stringBuffer=new StringBuffer();


        }

        return null;

    }



}
