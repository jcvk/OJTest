package oj;

import java.util.Stack;

/**
 * Created by Jvck on 2018/3/19.
 */
public class Question21 {

    public boolean chkLegal(String A) {
        Stack<Character> stack=new Stack<Character>();
        char[] array=A.toCharArray();

        for (int i=0;i<array.length;i++){
            if (array[i]=='{'||array[i]=='('||array[i]=='['||array[i]==']'||array[i]==')'||array[i]=='}'){
                if (!stack.isEmpty()){
                    if (array[i]=='{'||array[i]=='('||array[i]=='['){
                        stack.push(array[i]);
                    }else {
                        char temp=stack.peek();

                        if (temp=='{'&&array[i]=='}'){
                            stack.pop();
                        }
                        if (temp=='('&&array[i]==')'){
                            stack.pop();
                        }
                        if (temp=='['&&array[i]==']'){
                            stack.pop();
                        }

                    }
                }else {
                    stack.push(array[i]);
                }
            }
        }

        return stack.isEmpty();


    }
}
