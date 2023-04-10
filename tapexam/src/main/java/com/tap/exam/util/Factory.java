package com.tap.exam.util;

import com.tap.exam.model.Classification;
import com.tap.exam.model.Division;
import com.tap.exam.model.Humanities;
import com.tap.exam.model.Science;
import com.tap.exam.service.HumanityStrategy;
import com.tap.exam.service.ScienceStrategy;

public enum Factory {
    SCIENCE {
        public Classification.ClassificationBuilder getClassification() {
            return Classification.builder()
                    .rule(Constant.SCIENCE_REGEX)
                    .minScore(Constant.SCIENCE_CONDITION_SCORE)
                    .totalScore(Constant.MIN_TOTAL_SCORE);
        }

        @Override
        public Division parse(String dataInput) {
            Science science = new Science(new ScienceStrategy());
            DivisionReflection.setClassInfo(science.getClass().getName(), dataInput, science);
            return science;
        }
    },
    HUMANITIES {
        public Classification.ClassificationBuilder getClassification() {
            return Classification.builder()
                    .rule(Constant.HUMANITY_REGEX)
                    .minScore(Constant.HUMANITY_CONDITION_SCORE)
                    .totalScore(Constant.MIN_TOTAL_SCORE);
        }

        @Override
        public Division parse(String dataInput) {
            Humanities humanities = new Humanities(new HumanityStrategy());
            DivisionReflection.setClassInfo(humanities.getClass().getName(), dataInput, humanities);
            return humanities;
        }
    };

    Factory() {
    }

    public abstract Classification.ClassificationBuilder getClassification();

    public abstract Division parse(String dataInput);
}
