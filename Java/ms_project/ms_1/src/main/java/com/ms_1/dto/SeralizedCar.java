package com.ms_1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeralizedCar implements Serializable {
    private String name;
    private String model;
    private int age;
    private double tireWear;
    private char type;
    private float engineWear;
    private transient double totalWear;
}
