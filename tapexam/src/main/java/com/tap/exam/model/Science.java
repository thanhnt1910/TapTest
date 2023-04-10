package com.tap.exam.model;

import com.tap.exam.service.Calculate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Science extends Division {
    public Science(Calculate<Science> calculate) {
        super(calculate);
    }
}
