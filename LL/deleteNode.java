public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}


public void deleteNode(ListNode node) {
    ListNode prev = null;
    while(node != null && node.next != null){
        node.val = node.next.val;
        prev = node;
        node = node.next;
    }
    prev.next = null;
}

public void delete(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}

public static void main(String[] args) {
    
}