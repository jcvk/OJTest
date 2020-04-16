package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qindingkang on 2019/4/9.
 */
public class Test {
    public static void main(String[] args) {
        Test test=new Test();
        LinkNode node= test.reverse();
        System.out.println(node.value+"");
    }

    private void testTree() throws Exception {
        List<String> values = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            values.add(i + "");
        }
        Tree tree=new Tree();
        tree.createTree(values);
    }

    private LinkNode reverse(){
        LinkNode head=createLinkList();
        if (head==null||head.nextNode==null){
            return head;
        }

        LinkNode newHead;
        LinkNode nextNode;

        newHead=null;

        while (head!=null){
            nextNode=head.nextNode;
            head.nextNode=newHead;
            newHead=head;
            head=nextNode;
        }

        return newHead;
    }

    private LinkNode createLinkList(){
        LinkNode head=new LinkNode(0,null);
        LinkNode a=new LinkNode(1,null);
        LinkNode b=new LinkNode(2,null);
        LinkNode c=new LinkNode(3,null);
        LinkNode d=new LinkNode(4,null);
        LinkNode e=new LinkNode(5,null);
        LinkNode f=new LinkNode(6,null);
        LinkNode g=new LinkNode(7,null);
        head.nextNode=a;
        a.nextNode=b;
        b.nextNode=c;
        c.nextNode=d;
        d.nextNode=e;
        e.nextNode=f;
        f.nextNode=g;
        return head;
    }

}
