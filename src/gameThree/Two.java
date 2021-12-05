package gameThree;

/**
 * user:lufei
 * DATE:2021/12/5
 **/
public class Two {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode cur = head;
        int len = 1;
        while(cur.next!=null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        int mid = len/2;
        if(len==2) {
            cur.next=null;
            return head;
        }
        if(len==1) {
            return null;
        }
        for(int i=1;i<mid;i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}
