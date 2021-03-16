package linkedlist.design;

//https://leetcode.com/problems/design-linked-list
public class DoublyLinkedList {
    int size;
    DoubleNode head;//sentinel node as pseudo-head
    DoubleNode tail;

    public DoublyLinkedList() {
        size = 0;
        head = new DoubleNode(0);
        tail = new DoubleNode(0);
        head.next = tail;
        tail.previous = head;
    }

    //Get value at index
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        DoubleNode current = head;
        if (index <= size - index) {
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = 0; i < size - index; i++) {
                current = current.previous;
            }
        }

        return current.value;
    }

    public void addAtHead(int value) {
        DoubleNode predecessor = head;
        DoubleNode successor = head.next;

        size++;
        DoubleNode toAdd = new DoubleNode(value);
        toAdd.previous = predecessor;
        toAdd.next = successor;
        predecessor.next = toAdd;
        successor.previous = toAdd;
    }

    public void addAtTail(int value) {
        DoubleNode successor = tail;
        DoubleNode predecessor = tail.previous;

        size++;
        DoubleNode toAdd = new DoubleNode(value);
        toAdd.previous = predecessor;
        toAdd.next = successor;
        predecessor.next = toAdd;
        successor.previous = toAdd;
    }

    public void addAtIndex(int index, int value) {
        if (index > size) {
            return;
        }

        //if index is negative - insert at the head of list
        if (index < 0) {
            index = 0;
        }

        DoubleNode predecessor;
        DoubleNode successor;
        if (index < size - index) {
            predecessor = head;
            for (int i = 0; i < index; i++) {
                predecessor = predecessor.next;
            }
            successor = predecessor.next;
        } else {
            successor = tail;
            for (int i = 0; i < size - index; i++) {
                successor = successor.previous;
            }
            predecessor = successor.previous;
        }

        size++;

        DoubleNode toAdd = new DoubleNode(value);
        toAdd.previous = predecessor;
        toAdd.next = successor;
        predecessor.next = toAdd;
        successor.previous = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        DoubleNode predecessor;
        DoubleNode successor;
        if (index < size - index) {
            predecessor = head;
            for (int i = 0; i < index; i++) {
                predecessor = predecessor.next;
            }
            successor = predecessor.next.next;
        } else {
            successor = tail;
            for (int i = 0; i < size - index; i++) {
                successor = successor.previous;
            }
            predecessor = successor.previous.previous;
        }

        size--;
        predecessor.next = successor;
        successor.previous = predecessor;
    }
}
