package oj;

import java.util.Stack;

/**
 * Created by Jvck on 2018/3/17.
 */
public class Question20 {

    private static Stack<Integer> data=new Stack<>();
    Stack<Integer> min=new Stack<>();

    public void push(int node) {

        if (min.isEmpty()){
            min.push(node);
        }

        if(min.peek()>node){
            min.push(node);
        }
        data.push(node);

    }

    public void pop() {
        if(data.peek()==min.peek()){
            data.pop();
            min.pop();
        }else{
            data.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {

        if(min.isEmpty()){
            return (Integer)null;
        }
        return min.peek();
    }

    public static void main(String[] args) {
        Question20 question20=new Question20();
        data.push(null);
        question20.push(1);
        question20.push(2);
        question20.push(4);
        question20.push(3);
        question20.push(5);
        System.out.println(question20.min());
    }
}
