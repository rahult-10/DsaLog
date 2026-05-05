public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    while(l1 != null){
        s1.push(l1.val);
        l1 = l1.next;
    }
    while(l2 != null){
        s2.push(l2.val);
        l2 = l2.next;
    }
    int sum = 0;
    int carry = 0;
    ListNode ans = new ListNode(0);
    while (!s1.isEmpty() || !s2.isEmpty()) {
        if (!s1.isEmpty()) {
            sum += s1.pop();
        }
        if (!s2.isEmpty()) {
            sum += s2.pop();
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

public static void main(String[] args) {
    
}