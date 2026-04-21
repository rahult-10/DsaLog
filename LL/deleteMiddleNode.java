//Delete the Middle Node of a Linked List


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}


public ListNode deleteMiddleNode(ListNode head) {
    if(head == null || head.next == null){
        return null;
    }
    ListNode temp = head;
    int n = 0;
    while(temp != null){
        n++;
        temp = temp.next;
    }
    int result = n/2;
    temp = head;
    while(temp != null){
        result--;
        if(result == 0){
            ListNode middle = temp.next;
            temp.next = temp.next.next;
        }
        temp = temp.next;
    }
    return head;
}


public ListNode deleteMiddle(ListNode head) {
    if(head == null || head.next == null){
        return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    fast = fast.next.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    slow.next = slow.next.next;
    return head;
}

public static void main(String[] args) {
    
}