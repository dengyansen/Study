package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetCode5 {
    public static void main(String[] args) {
//        new leetCode5().longestPalindrome("bb");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

//        public ListNode removeNodes(ListNode head) {
//
//            Deque<ListNode> stack = new ArrayDeque<ListNode>();
//            while (head != null) {
//                stack.push(head);
//                head = head.next;
//            }
//            //将所有链表节点按从左到右的顺序压入栈中，同时新链表初始为空。
//
//            // 不断地从栈中弹出节点，如果节点的值大于等于新链表的表头节点值，那么将该节点插入新链表的表头，否则移除该节点。
//            for (; !stack.isEmpty(); stack.pop()) {
//                if (head == null ||stack.peek().val >= head.val) {
//                    stack.peek().next = head;
//                    head = stack.peek();
//                }
//            }
//            return head;

        }


    }
