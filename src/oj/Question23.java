package oj;


/**
 * Created by qindingkang on 2019/6/12.
 */
public class Question23 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        new Question23().initDate();
    }

    private void initDate() {
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(7);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode j = new TreeNode(2);
        TreeNode k = new TreeNode(3);

//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        e.left = f;
//        e.right = g;
        a.left=b;
        b.left=d;
        d.left=j;
        j.left=k;



        TreeNode root2 = new TreeNode(8);
        TreeNode h = new TreeNode(9);
        TreeNode i = new TreeNode(2);

        root2.left=h;
        h.left=i;

        boolean result = new Question23().HasSubtree(a, root2);
        System.out.println(result);

    }


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        if (root1 != null) {
            if (root1.val == 8 && root2.val == 8) {
                System.out.println("stop");
            }
            if (compare(root1, root2)) {
                return true;
            }
            if (HasSubtree(root1.right, root2)) {
                return true;
            }
            if (HasSubtree(root1.left, root2)) {
                return true;
            }

        }
        return false;

    }

    public boolean compare(TreeNode root1, TreeNode root2) {
        boolean flagR;
        boolean flagL;

        if (root1.val == root2.val) {
            if (root2.left == null && root2.right == null) {
                return true;
            }

            if (root2.left!=null){
                if (root1.left==null){
                    return false;
                }else {
                    flagL= compare(root1.left, root2.left);
                }
            }else {
                flagL=true;
            }

            if (root2.right!=null){
                if (root1.right==null){
                    return false;
                }else {
                    flagR= compare(root1.right, root2.right);
                }
            }else {
                flagR=true;
            }

            return flagL&&flagR;

        }
        return false;

    }


}
