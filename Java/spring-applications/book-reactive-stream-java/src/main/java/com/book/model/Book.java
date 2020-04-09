package com.book.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Table("books")
public class Book {
    @Id
    Integer id;

    String name;

}
