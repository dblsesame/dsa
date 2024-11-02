package leetcode.practice.linkedlist;

public class PalindromeLinkedList {


    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        //can't do it from both ends because the list is single direction
        //unless copy to an array  
        // Could you do it in O(n) time and O(1) space
        // fast and slow pointers to reach halfway and end in one loop
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is at half way point at the loop's end
        // reverse back the 2nd half
        ListNode halfway = reverse(slow.next);
        System.out.println("after reverse half");
        ListNode.printList(head);
        ListNode.printList(halfway);
        ListNode p1 = head;
        ListNode p2 = halfway;
        while (result == true && p2 != null ) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;

        }
        //reverse back the 2nd half, the first reverse already cut the chain so it wont ripple to first half
        reverse(halfway);
        System.out.println("after reverse back");
        ListNode.printList(head);
        return result;
    }

    public ListNode reverse(ListNode head) {
        //advance from both sides is not possible for single linked list
        //so instead we just reverse the pointer 'next' as we traverse the list
        //however, this means the pointer head will point to the tail when done
        //so we need to return the new head
        ListNode curr = head;
        ListNode prev = null;
        //save the current next
        //repoint next to prev
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
