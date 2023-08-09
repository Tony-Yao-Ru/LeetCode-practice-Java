import util.ListNode_2;
public class Main {
    public static void main(String[] args) {
        // Leetcode 2: add two number
        /*
        ListNode_2 node1 = new ListNode_2(-1);
        node1.next = new ListNode_2(0);
        node1.next.next = new ListNode_2(1);
        node1.next.next.next = new ListNode_2(2);
        ListNode_2.printList(node1); 

        ListNode_2 node2 = new ListNode_2(-1);
        node2.next = new ListNode_2(2);
        node2.next.next = new ListNode_2(1);
        node2.next.next.next = new ListNode_2(0);
        ListNode_2.printList(node2);
        
        ListNode_2 node3 = ListNode_2.addTwoNumbers(node1, node2);
        ListNode_2.printList(node3);
        */

        // Leetcode 19: Remove Nth Node From End of List
        ListNode_2 node1 = new ListNode_2(0);
        node1.next = new ListNode_2(1);
        node1.next.next = new ListNode_2(2);
        node1.next.next.next = new ListNode_2(3);
        node1.next.next.next.next = new ListNode_2(4);
        node1.next.next.next.next.next = new ListNode_2(5);
        ListNode_2.printList(node1);

        ListNode_2 result = ListNode_2.removeNthFromEnd(node1, 2);
        ListNode_2.printList(result);
    }
}
