package AddTwoNumbers;

import java.util.Iterator;
import java.util.Vector;

/**
 * 遇到最主要的坑就是int相加溢出的情况
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Vector<Integer> v1 = loopList(l1);
        Vector<Integer> v2 = loopList(l2);
        Vector<Integer> v3 = sumTwoVector(v1, v2);

        return addListNode(v3.iterator());
    }

    private ListNode addListNode(Iterator<Integer> v3) {
        if (!v3.hasNext()) {
            return null;
        }

        int val = v3.next();
        ListNode ln = new ListNode(val);
        ln.next = addListNode(v3);

        return ln;
    }

    private Vector<Integer> sumTwoVector(Vector<Integer> v1, Vector<Integer> v2) {
        boolean isAddOne = false;
        Vector<Integer> v3 = new Vector<>();
        for (int i = 0; i < (v1.size() >= v2.size() ? v1.size() : v2.size()); i++) {
            int v_1 = i >= v1.size() ? 0 : v1.get(i), v_2 = i >= v2.size() ? 0 : v2.get(i);
            int needAdd = v_1 + v_2 + (isAddOne ? 1 : 0);
            isAddOne = false;
            if (needAdd >= 10) {
                needAdd = needAdd % 10;
                isAddOne = true;
            }
            v3.add(needAdd);
        }

        // 如果加完了，还有一个进1
        if (isAddOne) {
            v3.add(1);
        }

        return v3;
    }

    private Vector<Integer> loopList(ListNode l) {
        Vector<Integer> result = new Vector<>();
        while (l != null) {
            result.add(l.val);
            l = l.next;
        }

        return result;
    }
}
