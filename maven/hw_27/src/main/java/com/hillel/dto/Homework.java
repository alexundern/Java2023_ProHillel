package com.hillel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors
public class Homework {
    private int id;
    private String name;
    private String description;
}
