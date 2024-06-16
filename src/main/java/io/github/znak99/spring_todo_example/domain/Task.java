package io.github.znak99.spring_todo_example.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "tasks")
@Getter
public class Task {
    @Id
    @Column(name = "id")
    private Long id;

}