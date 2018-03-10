package oj;

import java.util.Stack;

/**
 * Created by Jvck on 2018/2/18.
 */
public class Question9 {


    public Question9() {

        push(1);
        push(2);
        push(3);
        push(4);
        System.out.println(pop());
        System.out.println(pop());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {

        int temp;

        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                temp = stack1.pop();
                stack2.push(temp);
            }

        }

        return stack2.pop();


    }
}
