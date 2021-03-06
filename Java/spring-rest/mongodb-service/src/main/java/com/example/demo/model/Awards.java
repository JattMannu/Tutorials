package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class Awards {

    @Id
    private long id;

    private String label;
    private List<Award> list;

    @Data
    @AllArgsConstructor
    public class Award{
        private String name;
    }
}
