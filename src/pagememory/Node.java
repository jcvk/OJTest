package pagememory;

/**
 * Created by Jvck on 2018/3/10.
 */
public class Node {

    private char value;
    private Node left;
    private Node right;

    public Node(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void visit(){
        System.out.println(Character.toString(getValue()));
    }

    public static Node getTestTreeNode(){
        Node nodeTop=new Node('A');
        Node node1=new Node('B');
        Node node2=new Node('C');
        Node node3=new Node('D');
        Node node4=new Node('E');
        Node node5=new Node('F');
        Node node6=new Node('G');
        Node node7=new Node('H');
        Node node8=new Node('I');
        Node node9=new Node('J');

        nodeTop.setLeft(node1);
        nodeTop.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node4.setLeft(node5);
        node4.setRight(node6);
        node2.setLeft(node7);
        node2.setRight(node8);
        node7.setRight(node9);
        return nodeTop;
    }
}
