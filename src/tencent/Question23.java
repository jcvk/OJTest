package tencent;

import tencent.Question23.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question23 {

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

    // 使用队列进行排序，就不用自己进行排序，获取每个链表第一个节点的最小值
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return new ListNode();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        // 创建头节点
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        // 把数组中的每个的头节点加入到队列中进行第一次比较
        for (ListNode node : lists) {
            if (node!=null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if (p.next!=null){
                queue.add(p.next);
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode[] listNodes = {};
        ListNode temp = new Question23().mergeKLists(listNodes);
        System.out.println("123");
    }
}
