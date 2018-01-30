package oj;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;

/**
 * Created by Jvck on 2017/12/14.
 */
public class Question4 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] pre = {1, 2, 4, 7, 3, 5, 6, 8, 9};
    private int[] in = {4, 7, 2, 1, 5, 3, 9, 8, 6};

    public Question4() {
        new Solution();
    }

    public class Solution {

        public Solution() {
            TreeNode node = reConstructBinaryTree(pre, in);
            Mirror(node);
            int depth = TreeDepth(node, 0);
            System.out.println(depth);
            System.out.println("you got it");

        }

        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

            TreeNode node = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

            return node;


        }

        private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            TreeNode treeNode = new TreeNode(pre[preStart]);

            for (int i = inStart, j = 0; i <= inEnd; i++, j++) {

                if (pre[preStart] == in[i]) {
                    treeNode.left = reConstructBinaryTree(pre, preStart + 1, preStart + j, in, inStart, inStart + j - 1);
                    treeNode.right = reConstructBinaryTree(pre, preStart + 1 + j, preEnd, in, inStart + j + 1, inEnd);
                }

            }

            return treeNode;
        }

        private void Mirror(TreeNode root) {

            if (root != null) {
                TreeNode tempNode = root.left;
                root.left = root.right;
                root.right = tempNode;
                Mirror(root.right);
                Mirror(root.left);
            }

        }

        private int TreeDepth(TreeNode root, int deep) {

            if (root != null) {
                deep += 1;
                int deepLeft = TreeDepth(root.left, deep);
                int deepRight = TreeDepth(root.right, deep);

                if (deepLeft > deepRight) {
                    return deepLeft;
                } else return deepRight;
            }
            return deep;


        }


    }


}
