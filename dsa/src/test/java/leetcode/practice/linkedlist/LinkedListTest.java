package leetcode.practice.linkedlist;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class LinkedListTest 
{
    @Test
    public void testReverseLinkedList(){
        int[] init = {1,2,3,4,5};
        ListNode list1 = new ListNode(init);
        int[] init2 = {5,4,3,2,1};
        ListNode list2 = new ListNode(init2);
        System.out.println("initial state");
        ListNode.printList(list1);
        ListNode.printList(list2);

        PalindromeLinkedList pll = new PalindromeLinkedList();
        list2 = pll.reverse(list2);
        System.out.println("after reverse");
        ListNode.printList(list2);
        assertEquals(true, ListNode.isEqual(list1, list2));
    }

    @Test
    public void testPalindrome(){
        int[] init = {1,1,2,1};
        //int[] init = {1,2,3,2,1};
        ListNode list1 = new ListNode(init);

        //ListNode.printList(list1);
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertEquals(false, pll.isPalindrome(list1));
    }

    @Test
    public void testPalindromeTrue(){
        int[] init = {1,2,2,1};
        ListNode list1 = new ListNode(init);

        //ListNode.printList(list1);
        PalindromeLinkedList pll = new PalindromeLinkedList();
        assertEquals(true, pll.isPalindrome(list1));
    }
    @Test
    public void testArrayInstantiation() {
        int[] init = {1,1,2,1};
        ListNode list = new ListNode(init);
        ListNode.printList(list);
    }
}
