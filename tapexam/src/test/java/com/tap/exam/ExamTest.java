package com.tap.exam;

import com.tap.exam.util.Constant;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ExamTest {
    private static final String SAMPLE_DATA_1 = Constant.SAMPLE_DATA_1;
    private static final String SAMPLE_DATA_2 = Constant.SAMPLE_DATA_2;

    @Test
    public void getExamineesPassFromSampleData1() {
        int number = Exam.showExamineesPass(SAMPLE_DATA_1);
        Assertions.assertEquals(2, number);
    }

    @Test
    public void getExamineesPassFromSampleData2() {
        int number = Exam.showExamineesPass(SAMPLE_DATA_2);
        Assertions.assertEquals(3, number);
    }


}