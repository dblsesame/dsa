package leetcode.practice.linkedlist;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] vals){
        ListNode node = this;
        ListNode prev = null;
        for( int i=0; i< vals.length; i++){
            if (node == null) {
                node = new ListNode();
                prev.next = node;
            }
            node.val = vals[i];
            prev = node;
            node = node.next;
        }
    }

    public static void printNode (ListNode node) {
        System.out.print("("+node.val+")");
    }

    public static void printList(ListNode head) {
        ListNode node = head;
        while (node!=null) {
            printNode(node);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static boolean isEqual (ListNode node1, ListNode node2){
        
        while (node1 != null && node2 !=null) {
            if (node1.val != node2.val) return false;
            //this assumes that the list has no cycle or this is an infinite loop
            // what was I thinking back then? 
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node1 == null && node2 == null) {
            return true;
        }
        
        return false;
    }
}