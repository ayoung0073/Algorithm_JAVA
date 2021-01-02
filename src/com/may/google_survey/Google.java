package com.may.google_survey;

import java.util.Date;
import java.util.List;

public class Google {
    // name, description, 질문리스트, 질문Choices리스트
    private Long writerId;

    private String name; // 설문조사 이름

    private String description; // 설문조사 설명

    private String category;

    private Date startDate;

    private Date endDate;

    private int point;

    private boolean existFile;

    private String filename;

    private List<GoogleQuestion> googleQuestions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GoogleQuestion> getGoogleQuestions() {
        return googleQuestions;
    }

    public void setGoogleQuestions(List<GoogleQuestion> googleQuestions) {
        this.googleQuestions = googleQuestions;
    }
}

