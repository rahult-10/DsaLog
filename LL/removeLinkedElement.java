//Remove Linked List Element

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

public ListNode removeElements(ListNode head, int val) {
    ListNode curr = head;
    ListNode dummy = new ListNode(0);
    ListNode answer = dummy;
    while(curr != null){
        if(curr.val == val){
            while(curr!= null && curr.val == val){
                curr = curr.next;
            }
            dummy.next = curr;
        }
        else {
            dummy.next = curr;
            dummy = dummy.next;
            curr = curr.next;
        }
    }
    return answer.next;
}

public ListNode removeListElements(ListNode head, int val) {
    ListNode curr = head;
    ListNode dummy = new ListNode(0);
    ListNode answer = dummy;
    while(curr != null){
        if(curr.val == val){
            while(curr!= null && curr.val == val){
                curr = curr.next;
            }
        }
        else {
            dummy.next = curr;
            dummy = dummy.next;
            curr = curr.next;
        }
    }
    dummy.next = null;
    return answer.next;
}

public static void main(String[] args) {
    
}