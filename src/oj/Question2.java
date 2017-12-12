package oj;

import java.util.ArrayList;

/**
 * Created by Jvck on 2017/11/15.
 */
public class Question2 {

    public class ListNode{
        int val;
        ListNode next=null;

        ListNode(int val){
            this.val=val;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public Question2() {

        ListNode topListNode=new ListNode(1);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(3);
        ListNode listNode3=new ListNode(4);
        topListNode.setNext(listNode1);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        ArrayList<Integer> tempArrayList=new ArrayList<>();
        ListNode testNode=new ListNode(0);
        tempArrayList.addAll(printListFromTailToHead(null));
        for (Integer integer : tempArrayList){
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> tempArrayList=new ArrayList<>();

        if (listNode==null){
            return tempArrayList;
        }


        if (listNode.next==null){
            tempArrayList.add(listNode.val);
        }else {
            tempArrayList.addAll(printListFromTailToHead(listNode.next));
            tempArrayList.add(listNode.val);
        }


//        if (listNode!=null){
//            tempArrayList.addAll(printListFromTailToHead(listNode.next));
//            tempArrayList.add(listNode.val);
//        }

        return tempArrayList;

    }
}
