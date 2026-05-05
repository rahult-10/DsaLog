public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

    ListNode r1 = reverseList(l1);
    ListNode r2 = reverseList(l2);
    int sum = 0;
    int carry = 0;
    ListNode ans = new ListNode(0);
    while (r1 != null || r2 != null) {
        if (r1 != null) {
            sum += r1.val;
            r1 = r1.next;
        }
        if (r2 != null) {
            sum += r2.val;
            r2 = r2.next;
        }
        ans.val = sum%10;
        carry = sum/10;
        ListNode head = new ListNode(carry);
        head.next = ans;
        ans = head;
        sum = carry;
    }
    return carry == 0? ans.next : ans;
}

private ListNode reverseList(ListNode head) {
    ListNode dummy = null;
    while (head != null) {
        ListNode current = head.next;
        head.next = dummy;
        dummy = head;
        head = current;
    }
    return dummy;
}


public static void main(String[] args) {
    
}