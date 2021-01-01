package com.may.datastructure;

public class ListNode {
    public Object data;
    public ListNode next; // 다음 노드

    public ListNode(){
        this.data = null;
        this.next = null;
    }

    public ListNode(Object data){
        this.data = data;
        this.next = null;
    }

    public ListNode(Object data, ListNode next){
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return "ListNode(" + data.toString() + ")";
    }
}
