//Check If a list is Palindrome or removeNthNode

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

//M1 -> Using Stack
public boolean Palindrome(ListNode head){
    Stack<Integer> st = new Stack<>();
    ListNode temp = head;
    while(temp != null){
        st.push(temp.val);
        temp = temp.next;
    }
    temp = head;
    while(temp != null){
        if(temp.val != st.peek()){
            return false;
        }
        temp = temp.next;
        st.pop();
    }
    return true;
}


//M2 -> optimized
public boolean isPalindrome(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode newHead = reverse(slow.next);
    ListNode first = head;
    ListNode second = newHead;
    while(second != null){
        if(first.val != second.val){
            reverse(newHead);
            return false;
        }
        first = first.next;
        second = second.next;
    }
    reverse(newHead);
    return true;
}

public ListNode reverse(ListNode head){
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