package leet.code;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = this.addTwoNumbers(l1, l2, 0);
        return listNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2 , int carry) {
        //Did not make int to reduce memory-foot print
        int sum = l1.val + l2.val + carry;

        carry = sum / 10 ;
        ListNode result = new ListNode(sum % 10);

        if(l1.next != null &&  l2.next != null)
            result.next = addTwoNumbers(l1.next , l2.next ,carry);
        else if(l2.next != null)
            result.next = addTwoNumbers(new ListNode(0), l2.next ,carry);
        else if(l1.next != null)
            result.next = addTwoNumbers(l1.next, new ListNode(0) ,carry);
        else if(carry > 0)
            result.next = addTwoNumbers(new ListNode(0), new ListNode(0) ,carry);

        return result;
    }



    public ListNode addTwoNumbers_v1(ListNode l1, ListNode l2) {
        ListNode listNode = this.addTwoNumbers_v1(l1, l2, 0);
        return listNode;
    }
    public ListNode addTwoNumbers_v1(ListNode l1, ListNode l2 , int carry) {

        int sum = l1.val + l2.val + carry;
        carry =  sum / 10;
        ListNode listNode = new ListNode(sum % 10);

        if(l1.next != null && l2.next != null)
            listNode.next = addTwoNumbers_v1(l1.next , l2.next, carry);
        else if(l1.next != null && l2.next == null)
            listNode.next = addTwoNumbers_v1(l1.next , new ListNode(0), carry);
        else if(l1.next == null && l2.next != null)
            listNode.next = addTwoNumbers_v1(new ListNode(0), l2.next, carry);
        else if(carry > 0)
            listNode.next = new ListNode(carry);

        return listNode;
    }


}