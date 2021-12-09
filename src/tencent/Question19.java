package tencent;

public class Question19 {

    public static class ListNode {
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

    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这里有可能需要删除掉头节点，所以需要创建一个空的节点
        ListNode temp = new ListNode(0,head), right = head,left = temp;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return temp.next;
    }


    public static void main(String[] args) {




        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4,e);
        ListNode c = new ListNode(3,d);
        ListNode b = new ListNode(2,c);
        ListNode a = new ListNode(1,b);
        new Question19().removeNthFromEnd(a,2);
    }
}
