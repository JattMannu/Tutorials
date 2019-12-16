package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class Fellowships {

    @Id
    private long id;

    private String label;

    private List<Fellowship> list;

    @Data
    @AllArgsConstructor
    public class Fellowship{
        private String name;
    }

}
