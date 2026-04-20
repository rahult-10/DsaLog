// Linked List Cycle 2
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

public ListNode detect(ListNode head) {
    Map<ListNode, Integer> mp = new HashMap<>();
    ListNode temp = head;
    int timer = 1;
    while(temp != null){
        if(mp.containsKey(temp)){
            return temp;
        }
        mp.put(temp, timer);
        timer++;
        temp = temp.next;
    }
    return null;
}

public static void main(String[] args) {
    
}