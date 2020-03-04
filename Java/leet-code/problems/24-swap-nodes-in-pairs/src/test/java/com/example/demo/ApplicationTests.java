package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.management.ThreadInfo;

@SpringBootTest
class ApplicationTests {

    private int size(ListNode head) {
        if (head == null) return 0;
        int size = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            size += 1;
        }
        return size;
    }

    @Test
    void test_method_size() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        Assertions.assertEquals(3, size(head));
    }

    @Test
    void swap_1_item() {
        ListNode head = new ListNode(1, null);
        ListNode result = new Solution().swapPairs(head);

        Assertions.assertEquals(1, size(result));
    }


    @Test
    void swap_0_item() {
        ListNode head = new ListNode(1, null);
        ListNode result = new Solution().swapPairs(null);

        Assertions.assertEquals(0, size(result));
    }


    @Test
    void swap_2_item() {
        ListNode head = new ListNode(1, new ListNode(2, null));
        ListNode result = new Solution().swapPairs(head);

        Assertions.assertEquals(2, size(result));
        int[] values = {2, 1};
        assertValuesInLinklist(result, values);

    }


    @Test
    void swap_3_item() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result = new Solution().swapPairs(head);

        Assertions.assertEquals(3, size(result));
        int[] values = {2, 1, 3};
        assertValuesInLinklist(result, values);

    }

    @Test
    void swap_4_item() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode result = new Solution().swapPairs(head);

        Assertions.assertEquals(4, size(result));
        int[] values = {2, 1, 4, 3};
        assertValuesInLinklist(result, values);

    }

    private void assertValuesInLinklist(ListNode head, int[] values) {
        ListNode current = head;
        for (int value : values) {
            Assertions.assertEquals(value, current.val);
            current = current.next;
        }
    }
}


class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode current = head;
        ListNode temp_head = null;
        ListNode temp_tail = null;
        if (current != null && current.next != null) {
            ListNode a = current;
            current = current.next.next;
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            temp_head = b;
            temp_tail = a;
        }

        while (current != null && current.next != null){
            ListNode a = current;
            current = current.next.next;
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            temp_tail.next = b;
            temp_tail = a;
        }

        return temp_head == null ? head : temp_head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
