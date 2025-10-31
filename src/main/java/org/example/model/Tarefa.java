package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    private int id;
    private String todo;
    private boolean completed;
    private int userId;
}
