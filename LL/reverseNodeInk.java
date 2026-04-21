//Reverse Node in K group size
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}

public ListNode reverseKGroup(ListNode head, int k) {
    ListNode temp = head;
    ListNode nextNode;
    ListNode prevNode = null;

    while(temp != null){
        ListNode kNode = findkNode(temp, k);
        if(kNode == null){
            if(prevNode != null){
                prevNode.next = temp;
            }
            break;
        }
        nextNode = kNode.next;
        kNode.next = null;
        ListNode newNode = reverseList(temp);
        if(temp == head){
            head = newNode;
        }
        else {
            prevNode.next = newNode;
        }
        prevNode = temp;
        temp = nextNode;
    }
    return head;
}

private ListNode findkNode(ListNode temp, int k){
    k -= 1;
    while(temp != null && k > 0){
        k--;
        temp = temp.next;
    }
    return temp;
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