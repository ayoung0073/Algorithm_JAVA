package com.may;

public class SelectionSort {
    // swapElement
    // indexLowest
    // selectionSort

    // 배열에서 i와 j 위치에 있는 값 바꿈
    public static void swapElement(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int indexLowest(int[] array, int start){
        int idx = start;
        for(int i = start; i < array.length; i++)
            if(array[i] < array[idx])
                idx = i;
        return idx;
    }

    public static void selectionSort(int[] array){
        int idx = 0;
        for(int i = 0; i < array.length; i++){
            idx = indexLowest(array, i);
            swapElement(array, i, idx);
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{5, 3, 4, 8, 2};
        selectionSort(array);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
