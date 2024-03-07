public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 6, 3, 4, 5, 6};
        ListNode head1 = new ListNode(arr1);
        System.out.println(head1);
        System.out.println("==========删除后==========");
        ListNode removeElements1 = new Solution().removeElements(head1, 6);
        System.out.println(removeElements1);
        System.out.println();
        // 2
        int[] arr2 = {};
        ListNode head2 = new ListNode(arr2);
        System.out.println(head2);
        System.out.println("==========删除后==========");
        ListNode removeElements2 = new Solution().removeElements(head2, 1);
        System.out.println(removeElements2);
        System.out.println();
        // 3
        int[] arr3 = {7, 7, 7, 7};
        ListNode head3 = new ListNode(arr3);
        System.out.println(head3);
        System.out.println("==========删除后==========");
        ListNode removeElements3 = new Solution().removeElements(head3, 7);
        System.out.println(removeElements3);
    }
}
class ListNode {
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

    // 链表节点的构造函数
    // 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        this.val = arr[0];
        ListNode cur = this;
        //将数组值添加到链表中
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }
}

