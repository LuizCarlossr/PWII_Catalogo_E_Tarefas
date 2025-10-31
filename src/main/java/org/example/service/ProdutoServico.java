package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.util.ClienteHttp;
import org.example.model.Produto;
import org.example.model.RespostaProduto;

import java.util.List;

public class ProdutoServico {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Produto> listar(int limit, int skip) throws Exception {
        String json = ClienteHttp.get("https://dummyjson.com/products?limit=" + limit + "&skip=" + skip);
        RespostaProduto resposta = mapper.readValue(json, RespostaProduto.class);
        return resposta.getProducts();
    }

    public List<Produto> buscar(String termo) throws Exception {
        String json = ClienteHttp.get("https://dummyjson.com/products/search?q=" + termo);
        RespostaProduto resposta = mapper.readValue(json, RespostaProduto.class);
        return resposta.getProducts();
    }
}
