package linkedlist.medium;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class FlattenMultilevelList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int val, Node prev, Node next, Node child){
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
        public Node(int val){
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }
        // pseudo head to ensure the `prev` pointer is never none
        //Node dummy = new Node(0, null, head, null);
        Node dummy = new Node(0);

        flattenDFS(dummy, head);

        // detach the pseudo head from the real head
        dummy.next.prev = null;
        return dummy.next;
    }

    /* return the tail of the flatten list */
    private Node flattenDFS(Node prev, Node curr) {
        if(curr == null){
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;

        // the curr.next would be tempered in the recursive function
        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }
}
