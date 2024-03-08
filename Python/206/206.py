# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # 迭代解法
        cur, pre = head, None
        while cur:
            next= cur.next  # 先记录一下当前节点的下一个节点
            cur.next = pre  # 1.next=None, 2.next=1, 3.next=2, 4.next=3, 5.next=4 关键点：当前节点的下个节点指向pre,完成一次cur和pre的翻转
            pre = cur  # 当前节点指向上一个节点，即pre右移
            cur = next  # 当前节点的下一个节点指向当前节点(即当前节点cur右移)
        return pre
