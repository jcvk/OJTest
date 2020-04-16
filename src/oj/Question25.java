package oj;

import java.util.*;

/**
 * Created by qindingkang on 2019/6/12.
 */
public class Question25 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null){
            return result;
        }
        TreeNode temp=root;
        while (temp!=null){
            result.add(temp.val);
            if (temp.left!=null){
                queue.add(temp.left);
            }
            if (temp.right!=null){
                queue.add(temp.right);
            }
            if (!queue.isEmpty()){
                temp=queue.poll();
            }else {
                break;
            }

        }
        return result;
    }
}
