package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class Publications {

    @Id
    private long id;
    private String label;
    private List<Publication> list;

    @Data
    @AllArgsConstructor
    public class Publication{
        private String description;
    }

    public Publications(long id) {
        this.id = id;
    }
}
