package com.tap.exam.service;

import com.tap.exam.model.Division;

public interface Calculate<T extends Division> {
    int sumScoreOfTotalSubject(T t);

    int sumSubjectByCondition(T t);
}
