package oj;

import pagememory.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jvck on 2018/3/15.
 */
public class Question19 {

    private Queue<Node> queue=new LinkedList<>();
    private Stack<Node> stack1=new Stack<>();
    private Stack<Node> stack2=new Stack<>();

    public boolean HasSubtree(Node root1, Node root2) {

        if (root2==null){
            return false;
        }

        stack1.peek();

        Node node1=root1;
        Node node2=root2;
        queue.add(node1);

        while (!queue.isEmpty()){
            node1=queue.poll();

            if (node1.getValue()==node2.getValue()){

                while (node1!=null||!stack1.isEmpty()||node2!=null||!stack2.empty()){

                    while (node1!=null||node2!=null){
                        if (node1.getValue()!=node2.getValue()){
                            break;
                        }
                        stack1.push(node1);
                        stack2.push(node2);
                        node2=node2.getLeft();
                        node1=node1.getLeft();

                    }

                    if (!stack1.isEmpty()){
                        node1=stack1.pop();
                        System.out.println(node1.getRight().getValue());
                    }

                }

            }

            if (node1.getLeft()!=null){
                queue.add(node1.getLeft());
            }
            if (node1.getRight()!=null){
                queue.add(node1.getRight());
            }

        }

        return true;

    }

    public static void main(String[] args) {
        new Question19().HasSubtree(Node.getTestTreeNode(),null);
    }
}
