package com.tap.exam;

import com.tap.exam.util.Constant;
import com.tap.exam.util.Factory;
import com.tap.exam.exception.DataInputInvalidException;
import com.tap.exam.model.Division;
import com.tap.exam.validate.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Exam {
    private static final Logger logger = LoggerFactory.getLogger(Exam.class);

    public static int showExamineesPass (String inputData) {
        int numberExamineesPass = 0;

        List<String> examineesResult = new ArrayList<>();
        String[] data = inputData.split("\n");
        String numberExaminees = data[0];
        //Get result of examinees
        parseData(data, examineesResult);
        try {
            Validator.validate(numberExaminees, examineesResult);
            numberExamineesPass = calculateExamineesPass(examineesResult);
        } catch (DataInputInvalidException e) {
            logger.error(e.getMessage());
        } catch (NumberFormatException e) {
            logger.error("The first line must be the number of examinees");
        }
        return numberExamineesPass;
    }

    private static int calculateExamineesPass(List<String> examineesResult) throws DataInputInvalidException {
        int numberExamineesPass = 0;
        int minScore = 0;
        int totalScore = 0;
        for (String s : examineesResult) {
            Optional<Division> division = Optional.empty();
            for (Factory e : Factory.values()) {
                if (e.getClassification().build().isValid(s)) {
                    Division parse = e.parse(s);
                    division = Optional.of(parse);
                    //Get condition score by division
                    minScore = e.getClassification().build().getMinScore();
                    //Get total score
                    totalScore = e.getClassification().build().getTotalScore();
                    break;
                }
            }
            if (division.isPresent()) {
                //Compare score of all subject and score by division condition
                if (division.get().getCalculate().sumScoreOfTotalSubject(division.get()) >= totalScore
                        && division.get().getCalculate().sumSubjectByCondition(division.get()) >= minScore) {
                    numberExamineesPass++;
                }
            }
        }
        return numberExamineesPass;
    }

    private static void parseData(String[] inputData, List<String> examineesResult) {
        for (int i = 0; i < inputData.length; i++) {
            //ignore the first line, only get the score
            if (i == 0) {
                continue;
            }
            examineesResult.add(inputData[i]);
        }
    }
}
