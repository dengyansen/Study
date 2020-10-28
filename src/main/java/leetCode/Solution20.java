package leetCode;

import java.util.Stack;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1941 👎 0
public class Solution20 {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        if(s.length() % 2 == 1){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else  if(c == '{'){
                stack.push('}');
            }else  if(c == '['){
                stack.push(']');
            }else if(stack.size() ==0 ||  c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();

    }
}
