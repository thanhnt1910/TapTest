package com.tap.exam.model;

import com.tap.exam.util.Constant;
import com.tap.exam.exception.DataInputInvalidException;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Classification {
    private String rule;
    private int minScore;
    private int totalScore;

    public boolean isValid(String inputData) throws DataInputInvalidException {
        if (!inputData.matches(Constant.SCIENCE_REGEX) && !inputData.matches(Constant.HUMANITY_REGEX)) {
            throw new DataInputInvalidException("Please check input data " + inputData);
        }
        return inputData.matches(rule);
    }
}
