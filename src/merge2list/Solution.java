package merge2list;


// https://leetcode.com/problems/merge-two-sorted-lists/submissions/1250432664/
//  accept
public class Solution {
	public static void main(String[] args) {
		ListNode r3 = new ListNode(4);
		ListNode r2 = new ListNode(2, r3);
		ListNode r1 = new ListNode(1, r2);
		
		
		ListNode l3 = new ListNode(4);
		ListNode l2 = new ListNode(3, l3);
		ListNode l1 = new ListNode(1, l2);
		
		ListNode rs = mergeTwoLists(r1, l1);
		
		while(rs != null ) {
			System.out.println(rs.val);
			rs = rs.next;
		}
		
		
	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		ListNode rs = new ListNode();
		ListNode r = rs;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				rs.val = list1.val;
				rs.next = new ListNode();
				list1 = list1.next;
				rs = rs.next;
			} else {
				rs.val = list2.val;
				rs.next = new ListNode();
				list2 = list2.next;
				rs = rs.next;
			}
		}
		if (list1 == null && list2 != null) {
			while (list2 != null) {
				rs.val = list2.val;
				list2 = list2.next;
				if(list2 == null) break;
				rs.next = new ListNode();
				rs = rs.next;
			}
		} else if (list2 == null && list1 != null) {
			while (list1 != null) {
				rs.val = list1.val;
				list1 = list1.next;
				if(list1 == null) break;
				rs.next = new ListNode();
				rs = rs.next;
			}
		}
		return r;

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