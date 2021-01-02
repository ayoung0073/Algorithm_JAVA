package com.may.google_survey;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GoogleSurveyParsing {
    public static void main(String[] args) throws IOException {

        Google google = new Google();

        //String GOOGLE_SURVEY_URL = "https://docs.google.com/forms/d/e/1FAIpQLSdm96jFIVnaPcI4Y7pKmOBYbXWfgYY8qT7peHQXIMh8WqItxA/viewform";
        String GOOGLE_SURVEY_URL = "https://docs.google.com/forms/d/e/1FAIpQLSep1LVVOFC6xkHzGq7ZSUMFL41SDjXi7P4hAb_570b6NvIsaw/viewform?usp=sf_link";
        Document doc = Jsoup.connect(GOOGLE_SURVEY_URL).get();
        Element element = doc.selectFirst(".freebirdFormviewerViewHeaderTitleRow");
        //Element element = doc.selectFirst(".freebirdFormviewerViewHeaderTitle");

        google.setName(element.text());

        element = doc.selectFirst(".freebirdFormviewerViewHeaderDescription");
        google.setDescription(element.text());

        Elements boxElements = doc.select(".freebirdFormviewerViewNumberedItemContainer");
        //freebirdFormviewerComponentsQuestionBaseTitle
        String[] questions = new String[boxElements.size()];

        int idx = 0;
        int num = 1;
        for(Element e : boxElements) {
            questions[idx] = e.selectFirst(".freebirdFormviewerComponentsQuestionBaseTitle").text();
            System.out.println(questions[idx++]);

            // 0보다 크면 -> 라디오버튼 임 !!!
            if (e.getElementsByClass("freebirdFormviewerViewItemsRadiogroupRadioGroup").size() > 0)
                System.out.println("라디오");
            if (e.getElementsByClass("freebirdFormviewerComponentsQuestionCheckboxRoot").size() > 0)
                System.out.println("체크박스");
            if (e.getElementsByClass("freebirdFormviewerComponentsQuestionTextRoot").size() > 0)
                System.out.println("장문형");
            System.out.println();

            Elements elements = e.select(".docssharedWizToggleLabeledPrimaryText"); // 라디오 버튼 답
            for (Element eSub : elements)
                System.out.println(eSub.text());
            System.out.println("==========================================================================================");
        }

    }
}
