package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
public class ResearchExperiences{

    @Id
    private long id;
    private String label;
    private List<ResearchExperience> researchExperiences;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ResearchExperience {
        private String position;
        private String supervisor;
        private String title;
        private List<String> points;
    }

    public ResearchExperiences(long id) {
        this.id = id;
    }
}


