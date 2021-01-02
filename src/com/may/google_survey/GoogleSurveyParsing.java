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

        String GOOGLE_SURVEY_URL = "대상 URL 작성";

        Document doc = Jsoup.connect(GOOGLE_SURVEY_URL).get();
        Element element = doc.selectFirst(".freebirdFormviewerViewHeaderTitleRow"); // 설문조사 이름 select

        google.setName(element.text());

        element = doc.selectFirst(".freebirdFormviewerViewHeaderDescription"); // 설문조사 설명 select
        google.setDescription(element.text());

        Elements boxElements = doc.select(".freebirdFormviewerViewNumberedItemContainer"); // 각 질문 container


        List<GoogleQuestion> googleQuestionList = new ArrayList<>();
        for(Element e : boxElements) {

            // 질문 내용 & 필수항목 데이터

            GoogleQuestion googleQuestion = new GoogleQuestion();
            String questionText = e.selectFirst(".freebirdFormviewerComponentsQuestionBaseTitle").text(); // 질문내용 select
            googleQuestion.setQuestionText(questionText);
            if(questionText.charAt(questionText.length() - 1) == '*') { // 질문텍스트의 마지막 문자가 '*'이면 필수 문항에 해당
                googleQuestion.setRequired(true);
            }

            // 질문 카테고리 데이터

            String category = "";
            //  라디오 버튼 클래스명
            if (e.getElementsByClass("freebirdFormviewerViewItemsRadiogroupRadioGroup").size() > 0) category = "라디오";
            //  체크박스 클래스명
            if (e.getElementsByClass("freebirdFormviewerComponentsQuestionCheckboxRoot").size() > 0) category = "체크박스";
            //  텍스트 클래스명
            if (e.getElementsByClass("freebirdFormviewerComponentsQuestionTextRoot").size() > 0) category = "장문형";

            googleQuestion.setCategory(category);

            // 서브 질문 데이터

            Elements elements = e.select(".docssharedWizToggleLabeledPrimaryText"); // 서브 질문 텍스트 뽑기
            String[] subChoices = new String[elements.size()]; // 서브 질문 개수만큼 배열 선언
            int num = 0;
            for (Element eSub : elements) {
                subChoices[num++] = eSub.text();
            }

            googleQuestion.setQuestionChoices(subChoices);

            googleQuestionList.add(googleQuestion);

            google.setGoogleQuestions(googleQuestionList);
        }

        System.out.println(google.getName());
        System.out.println(google.getDescription());
        for(int i = 0; i < google.getGoogleQuestions().size(); i++){
            System.out.println("==============================================================================================================================================================================================");
            GoogleQuestion googleQuestion = googleQuestionList.get(i);
            System.out.println(googleQuestion.questionText);
            System.out.println("카테고리 : " + googleQuestion.category);
            System.out.println(googleQuestion.required?"(필수)":"(선택)");
            for(int j = 0; j < googleQuestion.getQuestionChoices().length; j++)
                System.out.println("    " +googleQuestion.questionChoices[j]);
        }
    }
}
