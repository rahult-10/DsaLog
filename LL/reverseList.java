//Reverse a singly linked list.

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public ListNode reverseList(ListNode head) {
    ListNode temp = head;
    Stack<Integer> st = new Stack<>();
    while(temp != null){
        st.push(temp.val);
        temp = temp.next;
    }
    temp = head;
    while(temp != null){
        temp.val = st.peek();
        st.pop();
        temp = temp.next;
    }
    return head;
}

public ListNode reverse(ListNode head) {
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
    return;
}