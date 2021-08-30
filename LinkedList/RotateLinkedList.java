## Rotate Linked List by K

Given a linked list node and a non-negative integer k, rotate the list to the right by k places.

Note: The linked list is guaranteed to have at least one element, and k is guaranteed to be less than or equal to the length of the list.

Constraints

k ≤ n ≤ 100,000 where n is the number of nodes in node
Example 1
Input
Visualize
node = 1 -> 2 -> 3 -> 4
k = 2

Output
Visualize

3 -> 4 -> 1 -> 2


import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */
class Solution {
    public LLNode solve(LLNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }
        LLNode curr = head;
        int n = 1;
        while(curr.next != null) {
            curr = curr.next;
            n++;
        }
        curr.next=head; 
        k=k%n;
        for(int i=0;i<n-k;i++){
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
        }
}
