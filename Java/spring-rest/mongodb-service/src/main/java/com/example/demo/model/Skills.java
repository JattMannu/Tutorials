package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class Skills {

    @Id
    private long id;
    private String label;
    private List<Skill> list;

    @Data
    @AllArgsConstructor
    public class  Skill{
        private String url;
        private String skill;
    }
}


