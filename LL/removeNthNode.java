// 19. Remove Nth Node From End of List

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

public ListNode removeNthNode(ListNode head, int n) {
    int cnt = 0;
    ListNode temp = head;
    while(temp != null){
        cnt++;
        temp = temp.next;
    }
    if(cnt == n){
        ListNode newHead = head.next;
        return newHead;
    }
    int result = cnt - n;
    temp = head;
    while(temp != null){
        result--;
        if(result == 0){
            break;
        }
        temp = temp.next;
    }
    ListNode remove = temp.next;
    temp.next = temp.next.next;
    return head;
}

//M2->
public ListNode removeNthfromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;
    for(int i = 0; i < n; i++){
        fast = fast.next;
    }
        if(fast == null){
        return head.next;
    }
    while(fast.next != null){
        slow = slow.next;
        fast = fast.next;
    }
    ListNode remove = slow.next;
    slow.next = slow.next.next;
    return head;
}

public static void main(String[] args) {
    return;
}