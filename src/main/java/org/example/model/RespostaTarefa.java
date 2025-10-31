package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespostaTarefa {
    private List<Tarefa> todos;
    private int total;
    private int skip;
    private int limit;
}
