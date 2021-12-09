package tencent;

public class Question24 {

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

    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode next = head.next;
        // 这里将返回值赋值给head.next就是将最小的递归连接起来的地方
        // 1<-2 3-<4
        // 通过这个复制实现了 3<-4<-1<-2
        head.next = swapPairs(next.next);
        // 交换
        next.next = head;
        return next;

    }

}
