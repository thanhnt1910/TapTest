package com.tap.exam.model;

import com.tap.exam.service.Calculate;
import lombok.Data;

@Data
public class Humanities extends Division {
    public Humanities(Calculate<Humanities> calculate) {
        super(calculate);
    }
}
