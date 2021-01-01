package com.may.jsoup_practice;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MyFetcher {

    public Elements fetch(String url, String className, String cssName) throws IOException {
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();

        Elements contents = doc.getElementsByClass(className);

        return contents.select(cssName);
    }
}
