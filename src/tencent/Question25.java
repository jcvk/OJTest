package tencent;

public class Question25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // 判断什么时候结束，那就多一个参数，余数小于k，那么就终止递归
        // 获取ListNode的长度，用来判断是否需要结束循环，那么这种情况，就不要使用递归了

        ListNode temp = head;
        int length = 0;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        return reverse(head,k,length);
    }

    private ListNode reverse(ListNode head,int k,int left){
        if (left<k){
            return head;
        }
        // 链表反转
        ListNode[] result = fun(head,k);
        head.next = reverse(result[1],k,left-k);
        return result[0];
    }

    // 链表反转不能用递归
    private ListNode[] fun(ListNode head,int k){
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null&&k>0){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            k--;
        }
        ListNode[] result = new ListNode[2];
        result[0] = pre;
        result[1] = curr;
        return result;
    }
}
