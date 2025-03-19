package removenodes;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/remove-nodes-from-linked-list/description
public class Solution {

	public static void main(String[] args) {
		
		
		ListNode l7 = new ListNode(7);
		ListNode l6 = new ListNode(9, l7);
		ListNode l5 = new ListNode(3, l6);
		ListNode l4 = new ListNode(8, l5);
		ListNode l3 = new ListNode(13, l4);
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(5, l2);
		
		ListNode rs = removeNodes(l1);
		while(rs != null ) {
			System.out.println(rs.val);
			rs = rs.next;
		}
		

	}
// solution 2
//	Accepted (s)
	public static ListNode removeNodes(ListNode head) {
		if(head.next == null) {
			return head;
		}
		
		List<Integer> list = new ArrayList<>();
		ListNode temp = head;
		int max = head.val;
		int i = 0;
		int imax = 0;
//		 find max value
		while(temp != null) {
			if(temp.val > max) {
				max = temp.val;
				head = temp;
				imax = i;
				
			}
			list.add(temp.val);
			temp = temp.next;
			i ++;
		}
//		kiem tra xem day co tang dan deu k, neu co phan tu k tang thi danh dau -1
		int maxVal = list.get(list.size() - 1);
		for(int index = list.size() - 2; index > imax; index--) {
			if(list.get(index) >= maxVal) {
				maxVal = list.get(index);
			}
			else {
				list.set(index, -1);
			}
		}
//		 remove node have value -1
		temp = head;
		ListNode pre = head;
		for(int index = imax; index < list.size(); index++) {
			if(list.get(index) == -1) {
				temp = temp.next;
				pre.next = temp;
			}
			else {
				pre = temp;
				temp = temp.next;
				
			}
		}
		
		
		
		
		return head;
	}
	
	
	
	
//	solution 1, Time Limit Exceeded
	
	
	
//	public static ListNode removeNodes(ListNode head) {
//		ListNode temp = head.next;
//		ListNode pre = head;
//		while(temp != null) {
//			if(temp.next != null && temp.val < temp.next.val) {
//				temp = temp.next;
//				pre = temp;
//			}
//			
//			
//			if(temp.val > head.val) {
//				head = temp;
//			}
//			temp = temp.next;
//			pre = temp;
//			
//		}
//		
//		pre = head;
//		temp = head.next;
//		while(temp != null) {
//			ListNode temp1 = temp.next;
//			while(temp1 != null) {
//				if(temp.val < temp1.val) {
//					pre.next = temp1;
//					temp = temp1;
//				}
//				temp1 = temp1.next;
//			}
//			temp = temp.next;
//			pre = pre.next;
//		}
//		
//		
//		return head;
//	}

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
