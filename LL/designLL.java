class designLL {

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node dummy; // dummy head
    private Node tail;
    private int size;

    public designLL() {
        dummy = new Node(0);
        tail = dummy;
        size = 0;
    }

    // Helper method
    private Node getNode(int index) {
        Node curr = dummy.next;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getNode(index).val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = dummy.next;
        dummy.next = newNode;

        if (size == 0) {
            tail = newNode;
        }

        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        // updating tail
        if (prev.next == tail) {
            tail = prev;
        }
        prev.next = prev.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */