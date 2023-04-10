package com.tap.exam.service;

import com.tap.exam.model.Science;

public class ScienceStrategy implements Calculate<Science> {

    @Override
    public int sumScoreOfTotalSubject(Science science) {
        //Sum all subjects
        return science.getEnglishScore() + science.getMathScore() + science.getScienceScore()
                + science.getJapaneseScore() + science.getGeographyScore();
    }

    @Override
    public int sumSubjectByCondition(Science science) {
        //Sum subjects by Science condition
        return science.getMathScore() + science.getScienceScore();
    }
}
