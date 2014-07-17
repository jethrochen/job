/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import java.util.Random;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next)
        	return head;
        ListNode headNode = new ListNode(0);
        headNode.next = head;

        ListNode p, q, s;
        
        q = head;
        while (q.next != null) {
        	p = headNode;
        	while (q.next.val > p.next.val && p != q) {
        		p = p.next;
        	}
        	if (p != q) {
        		s = q.next;
        		q.next = s.next;
        		s.next = p.next;
        		p.next = s;
        	} else {
        		q = q.next;
        	}

        }

        return headNode.next;
    }

    public static void main(String[] args) {
    	Solution ist = new Solution();
    	ListNode lNode1 = new ListNode((new Random()).nextInt(100));
    	lNode1.next = null;
    	ListNode lNode2 = new ListNode((new Random()).nextInt(100));
    	lNode2.next = lNode1;
    	ListNode lNode3 = new ListNode((new Random()).nextInt(100));
    	lNode3.next = lNode2;
    	ListNode lNode4 = new ListNode((new Random()).nextInt(100));
    	lNode4.next = lNode3;
    	ListNode lNode5 = new ListNode((new Random()).nextInt(100));
    	lNode5.next = lNode4;
    	ist.insertionSortList(lNode4);
    	ListNode ln = lNode4;
    	while (ln != null) {
    		System.out.println(ln.val);
    		ln = ln.next;
    	}
    }
}
