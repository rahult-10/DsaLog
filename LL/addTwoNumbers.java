class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;
    while(l1 != null || l2 != null){
        int sum = carry;
        if(l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            sum += l2.val;
            l2 = l2.next;
        }
        ListNode newNode = new ListNode(sum % 10);
        carry = sum/10;
        current.next = newNode;
        current = current.next;
    }
    if(carry != 0){
        ListNode newNode = new ListNode(carry);
        current.next = newNode;
    }
    return dummy.next;
}

public ListNode createList(int[] arr) {
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    for (int num : arr) {
        current.next = new ListNode(num);
        current = current.next;
    }

    return dummy.next;
}

public void printList(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " -> ");
        head = head.next;
    }
    System.out.println("null");
}

public void main(String[] args) {
    // Example: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    int[] arr1 = {2, 4, 3};
    int[] arr2 = {5, 6, 4};

    ListNode l1 = createList(arr1);
    ListNode l2 = createList(arr2);

    System.out.print("List 1: ");
    printList(l1);

    System.out.print("List 2: ");
    printList(l2);

    ListNode result = addTwoNumbers(l1, l2);

    System.out.print("Result: ");
    printList(result);
}