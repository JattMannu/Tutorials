package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resume")
public class Resume {

    @Id
    private long id;

    //@Indexed(unique = true)
    private String firstName;
    private String lastName;

    private PersonalProfile personalProfile;
}
