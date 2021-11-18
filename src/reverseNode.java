/** 记录一个链表翻转的问题
 * user:lufei
 * DATE:2021/11/18
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class reverseNode {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode pre = h;
        while(head!=null) {
            ListNode tail = pre;
            for(int i=0;i<k;i++) {
                tail = tail.next;
                if(tail==null) {
                    return h.next;
                }
            }
            ListNode net = tail.next;
            ListNode[] reverse = reverseList(head,tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = net;
            pre = tail;
            head = pre.next;
        }
        return h.next;
    }
    // 传如需要翻转的链表的头和尾
    public ListNode[] reverseList(ListNode head,ListNode tail) {
        ListNode h = head;
        ListNode v = h.next;
        while(h!=tail) {
            ListNode nex = v.next;
            v.next = h;
            h = v;
            v = nex;
        }
        ListNode[] li = {tail,head};
        return li;
    }
}
