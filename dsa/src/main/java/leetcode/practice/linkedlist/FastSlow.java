package leetcode.practice.linkedlist;

public class FastSlow {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;   
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;   
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            //reverse the link
            current.next = prev;
            //setup for the next iteration
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public int pairSum(ListNode head) {
        //first find the middle
        ListNode middle = middleNode(head);
        //reverse the 2nd half
        ListNode head2 = reverse(middle);
        //navigate from head and middle to find the max pair sum
        int max = 0;
        while (head != null && head2 != null) {
            max = Math.max(max, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
            
        }
        return max;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //find the left node
        ListNode dummy = new ListNode(0, head); //dummy node to handle the case when left = 1
        ListNode prev = dummy;
        for (int i=0; i<left-1; i++) {
            prev = prev.next;
        }
        ListNode leftNode = prev.next;
        //find the right node
        ListNode rightNode = leftNode;
        for (int i=0; i<right-left; i++) {
            rightNode = rightNode.next;
        }
        //reverse the list between left and right
        ListNode next = rightNode.next; //save the next node
        rightNode.next = null; //cut the chain to the right so that the reverse will not ripple past the right
        reverse(leftNode);
        //reconnect the list
        prev.next = rightNode;
        leftNode.next = next;
        return dummy.next;   
    }
}
