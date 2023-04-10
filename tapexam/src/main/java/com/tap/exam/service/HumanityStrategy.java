package com.tap.exam.service;

import com.tap.exam.model.Humanities;

public class HumanityStrategy implements Calculate<Humanities> {

    @Override
    public int sumScoreOfTotalSubject(Humanities humanities) {
        //Sum all subjects
        return humanities.getEnglishScore() + humanities.getMathScore() + humanities.getScienceScore()
                + humanities.getJapaneseScore() + humanities.getGeographyScore();
    }

    @Override
    public int sumSubjectByCondition(Humanities humanities) {
        //Sum subjects by Humanity condition
        return humanities.getJapaneseScore() + humanities.getGeographyScore();
    }
}
