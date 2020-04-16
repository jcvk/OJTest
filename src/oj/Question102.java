package oj;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by qindingkang on 2020/3/31.
 */
public class Question102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result = new ArrayList<>();


//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//       Queue<TreeNode> queue = new LinkedList<>();
//       queue.add(root);
//       int first = root.val;
//       int end = root.val;
//        List<Integer> temp = new ArrayList<>();
//
//       while (!queue.isEmpty()){
//           TreeNode top = queue.poll();
//           if (top.val == first){
//               temp.clear();
//           }
//           temp.add(top.val);
//
//           if (top.left!=null){
//               queue.add(top.left);
//               first = top.left.val;
//           }
//
//           if (top.right!=null){
//               queue.add(top.right);
//               end = top.right.val;
//           }
//
//           if (top.val == end){
//               result.add(temp);
//           }
//       }
//
//       return result;
//
//    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return result;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leve = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int leve_length = queue.size();
            for (int i = 0; i < leve_length; i++) {
                TreeNode top = queue.remove();
                result.get(leve).add(top.val);
                if (top.left != null) {
                    queue.add(top.left);

                }

                if (top.right != null) {
                    queue.add(top.right);
                }
            }
            leve++;
        }

        return result;
    }
}
