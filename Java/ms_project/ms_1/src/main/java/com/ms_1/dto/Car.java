package com.ms_1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String name;
    private String model;
    private int age;
    private double tireWear;
    private char type;
    private float engineWear;
    private transient double totalWear;
}
