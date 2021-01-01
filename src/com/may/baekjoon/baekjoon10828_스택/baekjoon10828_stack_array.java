package com.may.baekjoon.baekjoon10828_스택;

import java.util.Scanner;

public class baekjoon10828_stack_array { // 스택 배열로 구현 + StringBuilder

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        stack = new int[N];

        for(int i = 0; i < N; i++) {

            String str = sc.next();

            switch (str) {
                case "push" -> push(sc.nextInt());
                case "pop" -> sb.append(pop()).append('\n');
                case "size" -> sb.append(size()).append('\n');
                case "empty" -> sb.append(empty()).append('\n');
                case "top" -> sb.append(top()).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        }
        else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0) {
            return -1;
        }
        else {
            return stack[size - 1];
        }
    }

}