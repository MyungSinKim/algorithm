package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/2/16
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SortList {

    public static void main(String[] args) {

        ListNode head = new ListNode(12);
        head = addBack(head, 3);
        head = addBack(head, 10);
        head = addBack(head, 25);
        head = addBack(head, 12);
        head = addBack(head, 5);
        head = addBack(head, 55);

//        for (int i = 0; i < 100000; i++)
//            head = addBack(head, (int) (Math.random() * 100));
        print(head);

        new SortList().sortList(head);
        print(head);
    }

    public static ListNode addBack(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = null;
        ListNode node = head;
        if (head == null) {
            head = newNode;
            return head;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;

        return head;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partion(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;
        while (p2 != end) {

            if (p2.val < head.val) {
                p1 = p1.next;

                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }
}
