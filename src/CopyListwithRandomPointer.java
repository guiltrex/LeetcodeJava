//Do it with 3-pass algorithm, which doesn't require Map (very brilliant idea)
/**
 * Created by jniu on 6/29/17.
 */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode copy, res;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        for(RandomListNode cur = head; cur!=null; cur=cur.next){
            copy = new RandomListNode(cur.label);
            map.put(cur, copy);
        }

        copy = map.get(head);
        res = copy;

        for(RandomListNode cur = head; cur!=null; cur=cur.next, copy = copy.next){
            copy.next = cur.next == null? null : map.get(cur.next);
            copy.random = cur.random == null? null : map.get(cur.random);
        }
        return res;
    }
}