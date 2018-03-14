package pagememory;

import java.util.Stack;

/**
 * Created by Jvck on 2018/3/10.
 */
public class TreeTravel {



    private void preTravel(Node node){
        node.visit();
        if (node.getLeft()!=null){
            preTravel(node.getLeft());
        }
        if (node.getRight()!=null){
            preTravel(node.getRight());
        }
    }

    /**
     * 非递归实现前序遍历
     * @param p
     */
    private void preTravel1(Node p){
        Stack<Node> stack=new Stack<>();

        Node node=p;

        if (node==null) return;

        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                node.visit();
                stack.push(node);
                node=node.getLeft();
            }

//            if (!stack.isEmpty()){
                node=stack.pop().getRight();
//            }
        }
    }

    /**
     * 非递归中序遍历
     * @param p
     */
    private void iterativeInorder(Node p){

        Stack<Node> stack=new Stack<>();

        Node node=p;

        while (node!=null||!stack.isEmpty()){

            while (node!=null){
                stack.push(node);
                node=node.getLeft();
            }

            node=stack.pop();
            node.visit();

            node=node.getRight();

        }
    }

    /**
     * 非递归后序遍历
     * @param p
     */
    private void onRecPostOrder(Node p){
        Stack<Node> stack=new Stack<>();
        Node node=p;
        while (p!=null){
            for (;p.getLeft()!=null;p=p.getLeft()){
                stack.push(p);
            }

            while (p!=null&&(p.getRight()==null||p.getRight()==node)){
                p.getValue();
                node=p;

            }
        }
    }

    public static void main(String[] args) {

        Node nodeTop=Node.getTestTreeNode();
        new TreeTravel().preTravel1(nodeTop);
    }

}
