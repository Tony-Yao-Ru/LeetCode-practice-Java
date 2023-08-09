package util;

public class ListNode_2 {
    int val;
    public ListNode_2 next;
    public ListNode_2() {}
    public ListNode_2(int val) {this.val = val;}
    public ListNode_2(int val, ListNode_2 next) {this.val = val; this.next = next;}

    public static ListNode_2 addTwoNumbers(ListNode_2 l1, ListNode_2 l2) {
        ListNode_2 buffer = new ListNode_2(-1);
        ListNode_2 result = buffer;
        int carry = 0;
        int sum = 0;
        while ((l1 != null) || (l2 != null) || (carry != 0)) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            buffer.next = new ListNode_2(sum%10);
            buffer = buffer.next;
            carry = sum/10;
        }
        if (carry > 0) {
            buffer.next = new ListNode_2(carry);
        }
        return result.next;
    }
    
    public static ListNode_2 removeNthFromEnd(ListNode_2 head, int n) {
        if (head == null) {
            return null;
        }

        ListNode_2 result = new ListNode_2();
        result.next = head;

        ListNode_2 fast = result;
        ListNode_2 slow = result;

        for (int i=0; i<n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;

        return result.next;
    } 

    public static void printList(ListNode_2 node) {
        ListNode_2 currNode = node.next;
        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}