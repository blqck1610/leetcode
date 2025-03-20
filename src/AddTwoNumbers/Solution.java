package AddTwoNumbers;

public class Solution {
    public static void main(String[] args) {
        ListNode r3 = new ListNode(9);
        ListNode r2 = new ListNode(4, r3);
        ListNode r1 = new ListNode(2, r2);


        ListNode l4 = new ListNode(9);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);

        ListNode rs = addTwoNumbers(l1, r1);
        while (rs != null){
            System.out.println(rs.val);
            rs = rs.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int f = 0;

        while (l1 != null || l2 != null || f != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + f;
            int d = sum % 10;
            f = sum / 10;

            ListNode temp = new ListNode(d);
            tail.next = temp;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode rs = head.next;
        head.next = null;
        return rs;
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
