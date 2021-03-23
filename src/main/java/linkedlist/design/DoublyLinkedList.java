package linkedlist.design;

//https://leetcode.com/problems/design-linked-list
public class DoublyLinkedList {

    DoubleNode head;//sentinel node as pseudo-head

    public DoublyLinkedList() {
        this.head = null;
    }

    //Get value at index
    public int get(int index) {
        DoubleNode cur = getNode(index);
        return cur == null ? -1 : cur.value;
    }

    public void addAtHead(int value) {
        DoubleNode cur = new DoubleNode(value);
        cur.next = head;
        if (head != null) {
            head.previous = cur;
        }
        head = cur;
    }

    public void addAtTail(int value) {
        if (head == null) {
            addAtHead(value);
            return;
        }
        DoubleNode prev = getTail();
        DoubleNode cur = new DoubleNode(value);
        prev.next = cur;
        cur.previous = prev;
    }

    public void addAtIndex(int index, int value) {
        if (index == 0) {
            addAtHead(value);
            return;
        }
        DoubleNode prev = getNode(index - 1);
        if (prev == null) {
            return;
        }
        DoubleNode cur = new DoubleNode(value);
        DoubleNode next = prev.next;
        cur.previous = prev;
        cur.next = next;
        prev.next = cur;
        if (next != null) {
            next.previous = cur;
        }
    }

    public void deleteAtIndex(int index) {
        DoubleNode cur = getNode(index);
        if (cur == null) {
            return;
        }
        DoubleNode prev = cur.previous;
        DoubleNode next = cur.next;
        if (prev != null) {
            prev.next = next;
        } else {
            // modify head when deleting the first node.
            head = next;
        }
        if (next != null) {
            next.previous = prev;
        }
    }

    /** Helper function to return the index-th node in the linked list. */
    private DoubleNode getNode(int index) {
        DoubleNode cur = head;
        for (int i = 0; i < index && cur != null; ++i) {
            cur = cur.next;
        }
        return cur;
    }
    /** Helper function to return the last node in the linked list. */
    private DoubleNode getTail() {
        DoubleNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
