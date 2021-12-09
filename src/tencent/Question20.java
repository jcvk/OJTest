package tencent;

import java.util.ArrayList;
import java.util.Stack;

public class Question20 {

    // 用栈来判断
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if (c=='('||c=='{'||c=='['){
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()){
                return false;
            }
            if (c==')'){
                char p = stack.peek();
                if (p=='('){
                    stack.pop();
                }else {
                    return false;
                }
            }
            if (c=='}'){
                char p = stack.peek();
                if (p=='{'){
                    stack.pop();
                }else {
                    return false;
                }
            }
            if (c==']'){
                char p = stack.peek();
                if (p=='['){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new Question20().isValid("]");
    }
}
