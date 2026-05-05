public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    while(head != null){
        ListNode next = head.next;
        ListNode temp = dummy;

        while(temp.next != null && temp.next.val < head.val){
            temp = temp.next;
        }
        head.next = temp.next;
        temp.next = head;
        head = next;
    }
    return dummy.next;
}

public static void main(String[] args) {
    
}