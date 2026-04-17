public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
}
      
public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        right = sortList(right);
        return merge(left, right);
    }

public ListNode getMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

public ListNode merge(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy;

    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }

    if (list1 != null) {
        current.next = list1;
    } else {
        current.next = list2;
    }

    return dummy.next;
}

public static void main(String[] args) {
    return;
}