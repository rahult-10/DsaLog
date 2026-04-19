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
        if(temp.val == st.peek()){
            return false;
        }
        temp = temp.next;
        st.pop();
    }
    return true;
}



public static void main(String[] args) {
    
}