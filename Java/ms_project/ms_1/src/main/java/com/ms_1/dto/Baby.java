package com.ms_1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class Baby extends Person {

    private int boxNumber;
    private Toy toy;

    @Builder
    public Baby(String name, int boxNumber, Toy toy) {
        super(name);
        this.boxNumber = boxNumber;
        this.toy = toy;
    }
}
