package com.may.jsoup_practice;


import com.may.datastructure.wiki_node.NodeIterable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class MyCounter_noIterator {

    private Map<String, Integer> map; // <단어, 등장횟수>
    private String label; // url

    public MyCounter_noIterator(String label){
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
        for(Element node: elements){
//            for(Node node: new NodeIterable(root)) {
            // System.out.println(node);
            if (node.hasText()){ //instanceof TextNode) {
                // System.out.println(((TextNode) node).text());
                //map.pu(((TextNode) node).text(), map.get(((TextNode) node).text()) + 1);
                //String text = processText(((TextNode) node).text());
//                System.out.println(node.text());
                String text = processText(node.text());//.text());

                if(map != null)
                    map.put(text, map.get(text)==null?1:map.get(text) + 1);
                else
                    map.put(text, 1);
//                }
            }
        }
        // return map.keySet();
        return map;
    }

    public String processText(String text){
        text = text.split(" ] ")[0].replace("[ ","");
//        System.out.println(text);
        return text;
    }

}
