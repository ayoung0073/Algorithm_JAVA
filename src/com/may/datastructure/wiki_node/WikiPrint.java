package com.may.datastructure.wiki_node;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiPrint {
    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();

        // select the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");

        // TODO: avoid selecting paragraphs from sidebars and boxouts
        Elements paras = content.select("p");
        Element firstPara = paras.get(0); // root
//
//        System.out.println(firstPara);
        Iterable<Node> iter = new NodeIterable(firstPara);
        for(Node node: iter){
            if(node instanceof TextNode){
                System.out.print(node);
            }
        }
    }
}