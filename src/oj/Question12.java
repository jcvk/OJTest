package oj;


import org.w3c.dom.NodeList;

/**
 * Created by Jvck on 2018/2/19.
 */
public class Question12 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode L;

    public Question12() {

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode temp= ReverseList(node1);
        System.out.println(123);
    }

//    public ListNode ReverseList(ListNode head) {
//
//        if (head==null){
//            return null;
//        }
//
//        ListNode temp;
//
////        while (L.next!=null){
////            temp=L.next.next;
////            L.next.next=L;
////            temp.next=L.next;
////            L=temp;
////        }
////
////        while (L.next!=null){
////            L=L.next;
////        }
//        fun(head);
//
//
//        return L;
//
//
//
//    }


    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    ListNode fun(ListNode node){
        if (node.next!=null){
            ListNode temp=fun(node.next);
            temp.next=node;
            node.next=null;
        }else {
            L=node;
        }
        return node;
    }

}
