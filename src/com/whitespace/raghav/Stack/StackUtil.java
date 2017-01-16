package com.whitespace.raghav.Stack;

/**
 * Created by rbhatnagar2 on 9/20/15.
 */
public class StackUtil {
    public static void main(String[] args) {
        MyStackFromArray myStack = new MyStackFromArray(5);
        try {
            myStack.push(2);
            myStack.push(3);
            myStack.push(4);
            myStack.push(5);
            myStack.push(6);
            myStack.push(7);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
