package util;
/* Note:
 * The structure of Linked List is a self-referential struture.
 * Self-referential = data + link (either the address of an instance of list or the null pointer)
 */
public class LinkedList {
    ListNode head;
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Method to insert a new node 
    public static LinkedList insert(LinkedList list, int val) {
        // Create a new node for the given data
        ListNode new_node = new ListNode(val);
        if (list.head == null) {
            list.head = new_node;
        } else {
            ListNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(LinkedList list) {
        ListNode currNode = list.head;
        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.val + " ");
            currNode = currNode.next;
        }
    }
}