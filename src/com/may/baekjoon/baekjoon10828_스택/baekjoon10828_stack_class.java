package com.may.baekjoon.baekjoon10828_스택;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon10828_stack_class { // 스택 클래스 이용, StringBuilder

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Stack<Integer>  stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    int num = sc.nextInt();

    for(int i = 0; i < num; i++){
        String input = sc.next();

        switch (input) {
            case "push":
                stack.push(sc.nextInt());
                break;
            case "pop":
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                break;
            case "top":
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                break;
            case "empty":
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                break;
            case "size":
                sb.append(stack.size()).append("\n");
                break;
        }
    }
    System.out.println(sb);
    }
}
