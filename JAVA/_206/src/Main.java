public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // 创建并添加数值节点
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        linkedList.addNode(n1);
        linkedList.addNode(n2);
        linkedList.addNode(n3);
        linkedList.addNode(n4);
        linkedList.addNode(n5);

        System.out.println("反转之前:");
        linkedList.showNode();
        System.out.println();

        System.out.println("迭代反转之后:");
        linkedList.reversIterate();
        linkedList.showNode();
        System.out.println();

        System.out.println("再次递归反转:");
        linkedList.reverseRecurse();
        linkedList.showNode();
    }

}
class ListNode {
    public int no;
    public ListNode next;

    public ListNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }}
 class LinkedList {
    private ListNode head; // head节点

    public LinkedList() {
        head = new ListNode(0);
        head.no = 0;
        head.next = null;
    }

    public ListNode getHead() {
        return head;
    }

    // 显示链表
    public void showNode() {
        if (head.next == null) {
            System.out.println("链表为空!");
            return;
        }

        ListNode temp = head.next;
        while (temp != null) {
            System.out.print(temp.no + " ");
            temp = temp.next;
        }
    }

    // 添加元素
    public void addNode(ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    // 迭代实现链表反转
    public void reversIterate() {
        // 链表为空或者链表只有一个节点的时候，不需要反转
        if (head.next == null || head.next.next == null) {
            System.out.println("链表无需反转!");
            return;
        }

        ListNode previewNode = null; // 前一个节点指针
        ListNode currentNode = head.next; // 当前节点指针
        ListNode nextNode; // 下一个节点指针
        while (currentNode != null) {
            nextNode = currentNode.next;  // 保存当前节点的next值
            currentNode.next = previewNode; // 当前节点的next值指向前一个节点
            previewNode = currentNode; // 前一个节点指针指向当前节点
            currentNode = nextNode; // 当前节点指针指向下一个节点
        }
        head.next = previewNode;
    }

    public void reverseRecurse() {
        head.next = reverseNodeRecurse(head.next);
    }

    // 递归实现链表反转
    public ListNode reverseNodeRecurse(ListNode currentNode) {
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }

        // 递归当前节点的下一个节点
        ListNode nextNode = reverseNodeRecurse(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return nextNode;
    }
}
