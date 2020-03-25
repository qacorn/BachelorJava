package com.interview20181030;

public class ReverseLinkList {

    public static void reverseLinkedList(ListNode pHead){
        ListNode reverseNode = null;
        ListNode pNode = pHead;
        ListNode pPrev = null;
        while (pNode != null) {
            reverseNode = new ListNode(pNode.getData(), pNode.getNext());
            reverseNode.setNext(reverseNode);
        }

    }
}
