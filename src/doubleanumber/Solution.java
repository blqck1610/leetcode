package doubleanumber;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list
// accept
public class Solution {
	public static void main(String[] args) {
		ListNode l7 = new ListNode(7);
		ListNode l6 = new ListNode(9, l7);
		ListNode l5 = new ListNode(3, l6);
		ListNode l4 = new ListNode(8, l5);
		ListNode l3 = new ListNode(1, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(5, l2);
		
		ListNode rs = doubleIt(l1);
		
		while(rs != null ) {
			System.out.println(rs.val);
			rs = rs.next;
		}

	}

	public static ListNode doubleIt(ListNode head) {
		
		List<Integer> list = new ArrayList<>();
		List<Integer> rs = new ArrayList<>();
		
		
		ListNode temp = head;
		while(temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}
		
		int f = 0;
		
		for(int i = list.size() - 1; i > 0; i--) {
			if((list.get(i) * 2 + f ) >= 10) {
				rs.add((list.get(i) * 2 + f) % 10);
				f = 1;
			}
			else {
				rs.add(list.get(i) * 2 + f);
				f = 0;
			}
		}
		if((list.get(0) * 2 + f) >= 10) {
			rs.add((list.get(0) * 2 + f) % 10);
			rs.add(1);
		}
		else {
			rs.add(list.get(0) * 2 + f);
			
		}
		
		head = new ListNode();
		temp = head;
		for(int i = rs.size() - 1; i > 0; i--) {
			temp.val = rs.get(i);
			temp.next = new ListNode();
			temp = temp.next;
		}
		temp.val = rs.get(0);
		
		
		
		return head;

	}

}
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
