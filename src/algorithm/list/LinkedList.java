package algorithm.list;


import java.util.Stack;

/**
 * Created by think on 2016/9/20.
 * <p>
 * <p>
 * 1. 求单链表中结点的个数
 * 2. 将单链表反转
 * 3. 查找单链表中的倒数第K个结点（k > 0）
 * 4. 查找单链表的中间结点
 * 5. 从尾到头打印单链表
 * 6. 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序
 * 7. 判断一个单链表中是否有环
 * 8. 判断两个单链表是否相交
 * 9. 求两个单链表相交的第一个节点
 * 10. 已知一个单链表中存在环，求进入环中的第一个节点
 * 11. 给出一单链表头指针pHead和一节点指针pToBeDeleted，O(1)时间复杂度删除节点pToBeDeleted
 */


public class LinkedList {
    static class Node {
        int num;
        Node next;
    }

    public static void main(String[] args) {
        Node head = null, head2 = null;
        for (int i = 1; i <= 5; i++) {
//            head = addBack(head, (int) (Math.random() * 100));
            head = addBack(head, i);
        }
        for (int i = 2; i <= 6; i++) {
//            head = addBack(head, (int) (Math.random() * 100));
            head2 = addBack(head2, i);
        }
        show(head);
//        sort(head, null);
//        show(head);


        System.out.println("1. 求单链表中结点的个数");
        System.out.println("size=" + size(head));

        System.out.println("2. 将单链表反转");
//        head = (reverse(head));
//        show(head);

        System.out.println("3. 查找单链表中的倒数第K个结点（k > 0）");
        Node kNode = getKNode(head, 6);
        System.out.println(kNode != null ? kNode.num : null);

        System.out.println("4. 查找单链表的中间结点");
        Node midNode = getMidNode(head);
        System.out.println(midNode != null ? midNode.num : null);

        System.out.println("5. 从尾到头打印单链表");
        reversePrint2(head);
        System.out.println();

        System.out.println("6. 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序");
        Node node = merge(head, head2);

        System.out.println("7. 判断一个单链表中是否有环");
        System.out.println("8. 判断两个单链表是否相交");
        System.out.println("9. 求两个单链表相交的第一个节点");
        System.out.println("10. 已知一个单链表中存在环，求进入环中的第一个节点");
        System.out.println("11. 给出一单链表头指针pHead和一节点指针pToBeDeleted，O(1)时间复杂度删除节点pToBeDeleted");

        System.out.println();
    }

    public static Node addBack(Node head, int num) {
        Node newNode = new Node();
        newNode.num = num;
        newNode.next = null;
        Node node = head;
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

    public static void show(Node node) {
        while (node != null) {
//            System.out.println(node.num + " " + node+"  "+node.next);
            System.out.print(node.num + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 1. 求单链表中结点的个数
     * <p>
     * 思路
     *
     * @param head
     * @return
     */
    public static int size(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    /**
     * 2. 将单链表反转
     * <p>
     * 反转链表：遍历此链表，依次将节点插入到新链表的最前端，即可完成链表的反转
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {
        Node p1 = head, p2;
        head = null;
        while (p1 != null) {
            p2 = p1;
            p1 = p1.next;

            //头插法
            p2.next = head;
            head = p2;
        }
        return head;
    }

    /**
     * 3. 查找单链表中的倒数第K个结点（k > 0）
     * 第一种解法是得到顺数的第 size+k-1 个节点，即为倒数的第K歌节点
     * 第二种解法是快慢指针,主要思路就是使用两个指针，先让前面的指针走到正向第k个结点，
     * 这样前后两个指针的距离差是k-1，之后前后两个指针一起向前走，前面的指针走到最后一个结点时，
     * 后面指针所指结点就是倒数第k个结点。
     *
     * @param head
     * @return
     */
    public static Node getKNode(Node head, int k) {
        if (k < 0 || head == null) {
            return null;
        }
        Node p2 = head, p1 = head;
        while (k-- > 1 && p1 != null) {
            p1 = p1.next;
        }
        // 说明k>size，因此返回null
        if (k > 1 || p1 == null) {
            return null;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 4. 查找单链表的中间结点
     * 采用快慢指针，p1每次走两步，p2每次走一步，奇数返回size/2+1，偶数返回size/2,
     * 注意链表为空，链表结点个数为1和2的情况。
     *
     * @param head
     * @return
     */
    public static Node getMidNode(Node head) {
        if (head == null) {
            return null;
        }
        Node p1 = head, p2 = head;
        while (p1.next != null) {
            if (p1.next.next == null) {
                break;
            }
            p1 = p1.next.next;
            p2 = p2.next;

        }
        return p2;
    }

    /**
     * 5. 从尾到头打印单链表
     * 用栈
     *
     * @param node
     */
    public static void reversePrint(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().num + " ");
        }

    }

    /**
     * 5. 从尾到头打印单链表
     * 递归
     *
     * @param node
     */
    public static void reversePrint2(Node node) {
        if (node != null) {
            reversePrint2(node.next);
            System.out.print(node.num + " ");
        }
    }

    /**
     * 6. 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node merge(Node head1, Node head2) {
        Node head = null;
        Node p1 = null, p2 = null;
        if (head1.num > head2.num) {
            head = head2;
            p2 = head1;
        } else {
            head = head1;
            p2 = head2;
        }
        p1 = head.next;
        while (p1 != null || p2 != null) {
            if (p1.num > p2.num) {
                Node temp = p1;
                p1 = p1.next;
                temp.next = p2;
            }
        }
        return head;
    }

    /**
     * 单链表的双冒泡排序
     *
     * @param start
     * @param end
     */
    public static void sort(Node start, Node end) {
        if (start != end) {
            Node p1 = start;
            Node p2 = p1.next;
            while (p2 != end) {
                if (p2.num < start.num) {
                    p1 = p1.next;
                    int temp = p1.num;
                    p1.num = p2.num;
                    p2.num = temp;
                }
                p2 = p2.next;
            }
            int temp = p1.num;
            p1.num = start.num;
            start.num = temp;
            sort(start, p1);
            sort(p1.next, null);
        }

    }

}
