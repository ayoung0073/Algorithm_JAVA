package com.may.jsoup_practice;

import com.may.datastructure.wiki_node.NodeIterable;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class MyCounter {

    private Map<String, Integer> map; // <단어, 등장횟수>
    private String label; // url

    public MyCounter(String label){
        this.label = label;
        this.map = new HashMap<>();
    }

    public int size(){
        return map.size();
    }

    public String getLabel(){
        return label;
    }

    public Map<String, Integer> processElements(Elements elements){
        for(Node root: elements){
            // System.out.println("==" + root);
            // <h2>[ 알고리즘 - BOJ ] 2667. 단지번호붙이기</h2>
            for(Node node: new NodeIterable(root)) {
                //System.out.println(node);
                // <h2>[ 알고리즘 - BOJ ] 2667. 단지번호붙이기</h2>
                // [ 알고리즘 - BOJ ] 2667. 단지번호붙이기
                if (node instanceof TextNode) {
                     //System.out.println(((TextNode) node).text());
                     // [ 알고리즘 - BOJ ] 2667. 단지번호붙이기
                    //map.put(((TextNode) node).text(), map.get(((TextNode) node).text()) + 1);
                    String text = processText(((TextNode) node).text());
                    //System.out.println(text);
                    if(map != null)
                        map.put(text, map.get(text)==null?1:map.get(text) + 1);
                    else
                        map.put(text, 1);
                }
            }
        }
        // return map.keySet();
        return map;
    }

    public String processText(String text){
        //System.out.println(text);
        text = text.split(" ] ")[0].replace("[ ","");
        //System.out.println(text);
        return text;
    }

}
