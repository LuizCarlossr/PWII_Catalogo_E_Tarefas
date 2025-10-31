package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.util.ClienteHttp;
import org.example.model.RespostaTarefa;
import org.example.model.Tarefa;

import java.util.List;

public class TarefaServico {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Tarefa> listar(int limit, int skip) throws Exception {
        String json = ClienteHttp.get("https://dummyjson.com/todos?limit=" + limit + "&skip=" + skip);
        RespostaTarefa resposta = mapper.readValue(json, RespostaTarefa.class);
        return resposta.getTodos();
    }

    public Tarefa adicionar(String texto, int userId) throws Exception {
        String json = String.format("{\"todo\":\"%s\",\"completed\":false,\"userId\":%d}", texto, userId);
        String resposta = ClienteHttp.post("https://dummyjson.com/todos/add", json);
        return mapper.readValue(resposta, Tarefa.class);
    }

    public Tarefa marcar(int id, boolean completo) throws Exception {
        String json = String.format("{\"completed\":%s}", completo);
        String resposta = ClienteHttp.put("https://dummyjson.com/todos/" + id, json);
        return mapper.readValue(resposta, Tarefa.class);
    }

    public boolean remover(int id) {
        try {
            ClienteHttp.delete("https://dummyjson.com/todos/" + id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
