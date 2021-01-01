package com.may.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {

    long beforeTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기


    List<Integer> arrayList = new ArrayList<>();
    List<Integer> linkedList = new LinkedList<>(); // 이중

    long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
    long secDiffTime = (afterTime - beforeTime) / 1000; //두 시간에 차 계산
    System.out.println("시간차이(m) : " + secDiffTime);
    }
}
