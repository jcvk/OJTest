package oj;

import firstfit.Memory;

/**
 * Created by Jvck on 2018/2/19.
 */
public class Question13 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public Question13() {

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(5);

        node1.next=node2;
        node2.next=node3;


        ListNode node6=new ListNode(2);
        ListNode node7=new ListNode(4);
        ListNode node8=new ListNode(6);
        node6.next=node7;
        node7.next=node8;


        ListNode temp= Merge(node1,node6);
        System.out.println("666");



    }

    public ListNode Merge(ListNode list1, ListNode list2) {

        ListNode temp;
        ListNode L=new ListNode(-1);
        ListNode head=L;

        if (list1==null&&list2==null){
            return null;
        }

        if (list1==null){
            return list2;
        }

        if (list2==null){
            return list1;
        }

        while (list1!=null&&list2!=null){

            if (list1.val<=list2.val){
                temp=new ListNode(list1.val);
                list1=list1.next;
            }else {
                temp=new ListNode(list2.val);
                list2=list2.next;
            }
            L.next=temp;
            L=L.next;
        }

        if (list1==null){
            while (list2!=null){
                L.next=list2;
                list2=list2.next;
            }
        }else {
            while (list1!=null){
                L.next=list1;
                list1=list1.next;
            }
        }

        head=head.next;

        return head;
    }
}

