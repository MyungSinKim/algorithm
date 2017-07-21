package algorithm.list;


/**
 * Created by think on 2016/9/20.
 */
//实现一个单链表（有序），并且实现链表节点的插入，删除和遍历链表操作

class Student {
    int num;
    Student next;
}

public class LinkedList {
    public static void main(String[] args) {
        Student head = null;
        for (int i = 1; i <= 50; i++) {
            head = addBack(head, (int) (Math.random() * 100));
        }
        show(head);
        sort(head, null);
        System.out.println();
        show(head);
    }

    public static Student addBack(Student head, int num) {
        Student newStudent = new Student();
        newStudent.num = num;
        newStudent.next = null;
        Student student = head;
        if (head == null) {
            head = newStudent;
            return head;
        }
        while (student.next != null) {
            student = student.next;
        }
        student.next = newStudent;

        return head;
    }

    public static void show(Student student) {
        while (student != null) {
            System.out.println(student.num);
            student = student.next;
        }

    }

    public static void sort(Student start, Student end) {
        if (start != end) {
            Student p1 = start;
            Student p2 = p1.next;
            while (p2 != end) {
                if (p2.num < start.num) {
                    p1 = p1.next;
                    int temp = p1.num;
                    p1.num = p2.num;
                    p2.num = temp;
                }
                p2 = p2.next;
            }
            int temp = p1.num ;
            p1.num =start.num ;
            start.num =temp;
            sort(start, p1);
            sort(p1.next, null);
        }

    }

}
