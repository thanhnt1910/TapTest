package com.tap.exam.validate;

import com.tap.exam.util.Constant;
import com.tap.exam.exception.DataInputInvalidException;

import java.util.List;

public class Validator {
    public static void validate(String numberExaminees, List<String> examineesResult) throws DataInputInvalidException, NumberFormatException {
        int number = Integer.parseInt(numberExaminees);
        if (number < 0 || number > 1000) {
            throw new DataInputInvalidException("The number of examinees must >= 1 and <= 1000");
        }
        for (int i = 0; i < examineesResult.size(); i++) {
            String[] str = examineesResult.get(i).split("\\s+");
            if (str.length - 1 > Constant.TOTAL_SUBJECT) {
                throw new DataInputInvalidException("Total subject must equals " + Constant.TOTAL_SUBJECT);
            }
            for (int j = 0; j < str.length; j++) {
                if (j == 0) {
                    continue;
                }
                if (number < str.length - 1) {
                    throw new DataInputInvalidException("The number of the results must be equals examinees");
                }

                if (Integer.parseInt(str[j]) < 0 || Integer.parseInt(str[j]) > 100) {
                    throw new DataInputInvalidException("The number of examinees must >= 1 and <= 100");
                }
            }

        }
    }
}
