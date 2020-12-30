package com.may.baekjoon;

import java.util.*;

class Pos{
    int row, col;
    public Pos(int row, int col){
        this.col = col;
        this.row = row;
    }
}

public class baekjoon2178_maze {

    static int rowNum, colNum;
    static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 상하좌우 이동 배열
        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};

        rowNum = sc.nextInt();
        colNum = sc.nextInt();

        visited  = new int[rowNum][colNum];
        int i, j;

        int[][] mat = new int[rowNum][colNum];

        for(i = 0; i < rowNum; i++) {
            String input = sc.next();
            for (j = 0; j < colNum; j++) {
                mat[i][j] = Integer.parseInt(input.substring(j, j+1));
            }
        }

        Deque<Pos> deque = new LinkedList<>();
        visited[0][0] = 1;
        deque.add(new Pos(0, 0));

        Pos pos;
        while(!deque.isEmpty()){
            pos = deque.poll();
            int row = pos.row;
            int col = pos.col;
            for(i = 0; i < 4; i++){
                int x = row + xArr[i];
                int y = col + yArr[i];

                if(checkRange(x, y, mat)){ // 방문하지 않았고, 범위 안이면
                    deque.addLast(new Pos(x, y)); // enqueue
                    visited[x][y] = visited[row][col] + 1;
                }
            }
        }
        System.out.println(visited[rowNum-1][colNum-1]);
    }

    public static boolean checkRange(int x, int y, int[][] mat){
        // 범위 밖
        if(x >= rowNum || y >= colNum || x < 0 || y < 0) return false;
        // 이미 방문한 좌표인 경우
        else if(visited[x][y] != 0 || mat[x][y] == 0) return false;
        return true;
    }
}
