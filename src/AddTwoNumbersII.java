//Do again NOT using stacks
/**
 * Created by jniu on 7/11/17.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//68%
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l2 == null || l1==null) return l1==null?l2:l1;
        Deque<Integer> dq1 = new ArrayDeque<>();
        Deque<Integer> dq2 = new ArrayDeque<>();

        ListNode cur = l1;
        while(cur!=null){
            dq1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while(cur!=null){
            dq2.push(cur.val);
            cur = cur.next;
        }

        int carry = 0, n1, n2;
        cur = null;
        while(!dq1.isEmpty() || !dq2.isEmpty() || carry!=0){
            n1 = dq1.isEmpty()?0 : dq1.pop();
            n2 = dq2.isEmpty()?0 : dq2.pop();
            int tmp = n1 + n2 + carry;
            carry = tmp/10;
            ListNode next = cur;
            cur = new ListNode(tmp%10);
            cur.next = next;
        }
        return cur;
    }
}