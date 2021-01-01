package com.may.baekjoon.baekjoon10828_스택;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon10828_stack_fail_case { // 시간 초과 case
    public static void main(String[] args) {
        // 스캐너
        Scanner sc = new Scanner(System.in);

        // 명령의 수 num
        int num = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        String[] inputs = new String[num];
        for(int i = 0; i < num; i++) {
            inputs[i] = sc.nextLine();
        }

        for(int i = 0; i < num; i++){
            if(inputs[i].contains("push")){ // push
                stack.push(Integer.parseInt(inputs[i].split(" ")[1]));
            }
            else if(inputs[i].equals("top")){
                System.out.println(stack.isEmpty()?-1:stack.peek());
            }
            else if(inputs[i].equals("pop")){
                System.out.println(stack.isEmpty()?-1:stack.pop());
            }
            else if(inputs[i].equals("empty")){
                System.out.println(stack.isEmpty()?1:0);
            }
            else if(inputs[i].equals("size")){
                System.out.println(stack.size());
            }
            else{
                return;
            }
        }
    }
}
