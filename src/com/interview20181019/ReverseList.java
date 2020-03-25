package com.interview20181019;

public class ReverseList {

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node reverseHead = null;
        while (head != null) {
            Node current = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = current;
        }
        return reverseHead;
    }
}
