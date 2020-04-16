package oj;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by qindingkang on 2019/6/30.
 */
public class Question27 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }


    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        return null;
    }

    private ArrayList<ArrayList<Integer>> findEachPath(TreeNode root,int target){
        ArrayList<ArrayList<Integer>> path=new ArrayList<>();
        if (root==null){
            return null;
        }
        if (root.val>target) return null;
        ArrayList<Integer> currentDate=new ArrayList<>();
        currentDate.add(root.val);
        path.add(currentDate);
        path.add(currentDate);
        if (target-root.val>0){
            ArrayList<ArrayList<Integer>> resultLeft=findEachPath(root.left,target-root.val);
            if (resultLeft!=null){
                path.addAll(resultLeft);
            }
            ArrayList<ArrayList<Integer>> resultRight=findEachPath(root.right,target-root.val);
            if (resultRight!=null){
                path.addAll(resultRight);
            }
        }
        return path;
    }

    public static void main(String[] args) {
        TreeNode a=new TreeNode(10);
        TreeNode b=new TreeNode(5);
        TreeNode c=new TreeNode(12);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(7);

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;

        new Question27().findEachPath(a,22);
    }


}
