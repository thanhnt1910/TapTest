package com.tap.exam.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectScore implements Serializable {
    private int englishScore;
    private int mathScore;
    private int scienceScore;
    private int japaneseScore;
    private int geographyScore;
}
