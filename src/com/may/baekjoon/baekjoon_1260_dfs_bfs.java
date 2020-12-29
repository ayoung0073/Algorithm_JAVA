package com.may.baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class baekjoon_1260_dfs_bfs {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vCnt = sc.nextInt();
        int eCnt = sc.nextInt();
        int vStart = sc.nextInt();

        // int vCnt = 0; vCnt = sc.nextInt(); 이런 식으로 코딩 -> 런타임 에러

        int[][] mat = new int[vCnt][vCnt]; // 이차원 행렬(matrix)

        boolean[] visited = new boolean[vCnt];

        int i, start, end;
        for(i = 0; i < eCnt; i++) {
            start = sc.nextInt();
            end = sc.nextInt();

            mat[start - 1][end - 1] = 1;
            mat[end - 1][start - 1] = 1;
        }

        dfs(mat, vStart - 1, visited);

        System.out.println();
        visited = new boolean[vCnt];

        bfs(mat, vStart - 1, visited);
    }

    public static void dfs(int[][] mat, int start, boolean[] visited){
        visited[start] = true;
        System.out.print(start + 1 + " ");
        for(int i = 0; i < mat.length; i++){
            if(mat[start][i] == 1 && !visited[i]){
                dfs(mat, i, visited);
            }
        }
    }

    public static void bfs(int[][] mat, int start, boolean[] visited) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(start);
        visited[start] = true;

        while(!deque.isEmpty()){
            start = deque.removeFirst();
            System.out.print(start + 1 + " ");
            for(int i = 0; i < mat.length; i++) {
                if (mat[start][i] == 1 && !visited[i]){
                    visited[i] = true;
                    deque.addLast(i);
                }
            }
        }
    }
}