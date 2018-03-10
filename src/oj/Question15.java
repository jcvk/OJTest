package oj;

/**
 * Created by Jvck on 2018/2/20.
 */
public class Question15 {

    private int sum;
    private ListNode result;


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public Question15() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;

        ListNode temp = FindKthToTail(node1, 2);
        System.out.println(666);
    }
//
//    public ListNode FindKthToTail(ListNode head, int k) {
//        sum=k;
//        fun(head);
//        return result;
//
//    }

//    public int fun(ListNode node){
//
//
//        if (node==null){
//            return 1;
//        }else {
//            if (fun(node.next)==1){
//                sum--;
//                if (sum==0){
//                    result=node;
//                }
//                return 1;
//            }else {
//                return 0;
//            }
//        }
//
//
//    }

    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k < 0) {
            return null;
        }

        ListNode pre;
        ListNode last;

        pre=last=head;

        for (int i=0;i<k;i++){

            if (pre!=null){
                pre=pre.next;
            }else {
                return null;
            }
        }

        while (pre!=null){
            pre=pre.next;
            last=last.next;
        }

        return last;

    }
}
