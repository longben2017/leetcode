package leetcode.mergeTwoSortedLists;

public class Solution {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode mergeTwoLists = mergeTwoLists(l1,l2);
		while(mergeTwoLists != null){
			System.out.println(mergeTwoLists.val);
			mergeTwoLists = mergeTwoLists.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;

        ListNode resultHead;
        if(l1.val<l2.val){
            resultHead=l1;
            resultHead.next=mergeTwoLists(l1.next,l2);
        }else{
            resultHead=l2;
            resultHead.next=mergeTwoLists(l1,l2.next);
        }
        return resultHead;
    }
}
