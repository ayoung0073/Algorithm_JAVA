package com.may.jsoup_practice;

import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;

public class MyVelog {
    public static void main(String[] args) throws IOException {
        String url = "https://velog.io/@ayoung0073";

        MyFetcher fetcher = new MyFetcher();
        MyCounter counter = new MyCounter(url);

        Elements elements = fetcher.fetch(url, "sc-iujRgT igQOMp", "h2");
        // element < Node
//        Node의 밑에 Element가 있고
//        element: one specific type of node. 예를 들어  div, body, window 같은 특정한 타입.
//                모든 element는 HTMLElement의 자식이다. 따라서, HTMLElement의 property를 똑같이 가지고 있다. 동시에, element의 성격에 따라서 자신만의 property를 가지고 있다.

        //System.out.println(elements);

        Map<String, Integer> map = counter.processElements(elements);

        System.out.println("대상 URL : " + counter.getLabel());

        System.out.println("총 카테고리 개수 : " + counter.size());

        for(String key: map.keySet()){
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
