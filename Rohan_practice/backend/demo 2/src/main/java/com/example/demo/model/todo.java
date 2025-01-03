package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo")

public class todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter
    @Getter
    @JsonProperty("taskid") //
    private Long Taskid;
    @Setter
    @Getter
    @JsonProperty("task")
    private String Task;
}
