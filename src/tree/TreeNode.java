package tree;



/**
 * Created by qindingkang on 2019/4/8.
 */
public class TreeNode{
    private String value;
    private TreeNode leftNode;
    private TreeNode rightNode;


    public TreeNode(String value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
