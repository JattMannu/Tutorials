package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    private int size(ListNode result) {
        if (result == null) return 0;
        ListNode current = result;

        int size = 1;
        while (current != null && current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        ;
        return size;
    }

	private void assertEachListNode(ListNode head , int[] values) {
		ListNode current = head;
		for (int value : values) {
			Assertions.assertEquals(value, current.getVal());
			current = current.getNext();
		}
	}

    @Test
    void remove_last_item_from_list_of_size_1() {
        ListNode head = new ListNode(1, null);
        ListNode result = new Solution().removeNthFromEnd(head, 1);

        int size = size(result);
        Assertions.assertEquals(0, size);

    }

    @Test
    void remove_last_item_from_list_of_size_2() {
        ListNode head = new ListNode(1, new ListNode(2, null));
        ListNode result = new Solution().removeNthFromEnd(head, 1);

        int size = size(result);
        Assertions.assertEquals(1, size);
		assertEachListNode(result , new int[]{1} );
    }

    @Test
    void remove_last_item_from_list_of_size_3() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode result = new Solution().removeNthFromEnd(head, 1);

        int size = size(result);
        Assertions.assertEquals(2, size);

		assertEachListNode(result , new int[]{1, 2} );
    }


    @Test
    void remove_last_item_from_list_of_size_4() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode result = new Solution().removeNthFromEnd(head, 1);

        int size = size(result);
        Assertions.assertEquals(3, size);

		assertEachListNode(result , new int[]{1, 2, 3} );

	}

	@Test
	void remove_second_last_item_from_list_of_size_4() {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
		ListNode result = new Solution().removeNthFromEnd(head, 2);

		int size = size(result);
		Assertions.assertEquals(3, size);

		assertEachListNode(result , new int[]{1, 2, 4} );

	}

	@Test
	void remove_third_last_item_from_list_of_size_4() {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
		ListNode result = new Solution().removeNthFromEnd(head, 3);

		int size = size(result);
		Assertions.assertEquals(3, size);

		assertEachListNode(result , new int[]{1, 3, 4} );
	}

	@Test
	void remove_first_item_from_list_of_size_4() {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
		ListNode result = new Solution().removeNthFromEnd(head, 4);

		int size = size(result);
		Assertions.assertEquals(3, size);

		assertEachListNode(result , new int[]{2, 3, 4} );
	}
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp_head = new ListNode(-1, head);
        ListNode current = head;
        int current_loc = 1;
        int node_right_before_delete_loc = 0;

        ListNode prev_current = temp_head;
        while (current != null && current.hasNext()) {
			if(current_loc - node_right_before_delete_loc == n){
				prev_current = prev_current.getNext();
				node_right_before_delete_loc += 1;

			}
            current = current.getNext();
            current_loc += 1;
        }
        prev_current.setNext(prev_current.getNext().getNext());
        return temp_head.getNext();
    }


}
