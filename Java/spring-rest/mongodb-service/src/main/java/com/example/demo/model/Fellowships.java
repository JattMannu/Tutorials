package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Fellowships {

    @Id
    private long id;

    private String label;

    private List<Fellowship> fellowships;

    @Data
    @AllArgsConstructor
    public class Fellowship{
        private String name;
    }

    public Fellowships(long id) {
        this.id = id;
    }
}
