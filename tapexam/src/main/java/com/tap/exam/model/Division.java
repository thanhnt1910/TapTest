package com.tap.exam.model;

import com.tap.exam.service.Calculate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Division extends SubjectScore {
    private Calculate calculate;
}
