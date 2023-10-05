package com.example.restmongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Document
@Getter
@Setter
public class Todo {

    @Id
    String todo;
    int priority = 2;

}
