// Detect a Loop or Cycle in LL

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

public boolean hasCycle(ListNode head) {
    Map<ListNode, Integer> mp = new HashMap<>();
    ListNode temp = head;
    while(temp != null){
        if(mp.containsKey(temp)){
            return true;
        }
        mp.put(temp,1);
        temp = temp.next;
    }
    return false;
}

public boolean cycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast)
            return true;
    }
    return false;
}

public static void main(String[] args) {
    
}