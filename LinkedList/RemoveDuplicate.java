/*

82. Remove Duplicates from Sorted List II
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        ListNode res=new ListNode(0,head);
        ListNode prev=res;
        
        while(curr!=null ){
            if(curr.next!=null && curr.val==curr.next.val ){
                while(curr.next!=null && curr.val==curr.next.val ){
                    curr=curr.next;
                }
                prev.next=curr.next;
            }
            else{
                prev=prev.next;   
            }curr=curr.next;
        }
        
        return res.next;
    }
}
