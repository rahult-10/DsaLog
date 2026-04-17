//328. Odd Even Linked List

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null){
        return head;
    }   
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = head.next;
    while(even != null && even.next != null){
        odd.next = odd.next.next;
        even.next = even.next.next;

        odd = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
}

public static void main(String[] args) {
    return;
}