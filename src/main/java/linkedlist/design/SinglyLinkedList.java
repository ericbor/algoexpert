package linkedlist.design;

//https://leetcode.com/problems/design-linked-list
public class SinglyLinkedList {
    int size;
    ListNode head;//sentinel node as pseudo-head

    public SinglyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    //Get value at index
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public void addAtHead(int value) {
        addAtIndex(0, value);
    }

    public void addAtTail(int value) {
        addAtIndex(size, value);
    }

    public void addAtIndex(int index, int value) {
        if (index > size) {
            return;
        }

        //if index is negative - insert at the head of list
        if (index < 0) {
            index = 0;
        }

        size++;

        ListNode predecessor = head;
        for (int i = 0; i < index; i++) {
            predecessor = predecessor.next;
        }

        ListNode toAdd = new ListNode(value);
        toAdd.next = predecessor.next;
        predecessor.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;
        ListNode predecessor = head;
        for (int i = 0; i < index; i++) {
            predecessor = predecessor.next;
        }
        predecessor.next = predecessor.next.next;
    }
}
