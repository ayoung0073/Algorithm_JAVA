package com.may.datastructure;

class ClassName<E>{

    private E element; // 제네릭 변수

    E get(){ // 제네릭 메서드
        return element;
    }

    void set(E element){ // 제네릭 메서드
        this.element = element;
    }
}

public class Generic{
    public static void main(String[] args) {
        ClassName<String> str = new ClassName<String>();
        ClassName<Integer> num = new ClassName<Integer>();

        str.set("1");
        num.set(1);

        System.out.println("str data : " + str.get());
        System.out.println("str E Type : " + str.get().getClass().getName());
        // 반환된 변수 타입

        System.out.println();
        System.out.println("num data : " + num.get());
        System.out.println("num E Type : " + num.get().getClass().getName());
    }
}