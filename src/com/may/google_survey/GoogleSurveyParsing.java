package com.may.google_survey;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<GoogleQuestion> googleQuestionList = new ArrayList<>();
        int requiredCount = 0;
        for(Element e : boxElements) {
            GoogleQuestion googleQuestion = new GoogleQuestion();
            questions[idx] = e.selectFirst(".freebirdFormviewerComponentsQuestionBaseTitle").text();
            googleQuestion.setQuestionText(questions[idx]);
            if(questions[idx].charAt(questions[idx].length() - 1) == '*') {
                googleQuestion.setRequired(true);
                requiredCount++;
            }
//            System.out.println(questions[idx++]);

            String category = "";

            // 0보다 크면 -> 라디오버튼 임 !!!
            if (e.getElementsByClass("freebirdFormviewerViewItemsRadiogroupRadioGroup").size() > 0) category = "라디오";
            if (e.getElementsByClass("freebirdFormviewerComponentsQuestionCheckboxRoot").size() > 0) category = "체크박스";
            if (e.getElementsByClass("freebirdFormviewerComponentsQuestionTextRoot").size() > 0) category = "장문형";
            googleQuestion.setCategory(category);
//            System.out.println(category);
//            System.out.println();

            Elements elements = e.select(".docssharedWizToggleLabeledPrimaryText"); // 라디오 버튼 답
            String[] subChoices = new String[elements.size()];
            int num = 0;
            for (Element eSub : elements) {
                subChoices[num++] = eSub.text();
//                System.out.println(eSub.text());
            }
            googleQuestion.setQuestionChoices(subChoices);
            googleQuestionList.add(googleQuestion);

            google.setGoogleQuestions(googleQuestionList);
//            System.out.println("==========================================================================================");


        }
        System.out.println(requiredCount);

        System.out.println(google.toString());


    }
}
