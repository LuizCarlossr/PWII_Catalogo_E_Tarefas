# Exercício 2: Console App “Catálogo & Tarefas” (DummyJSON)

Este projeto é uma aplicação de console em Java que interage com a API [DummyJSON](https://dummyjson.com/) para listar produtos e tarefas. O objetivo é praticar modelagem com Lombok, consumo de APIs REST, e organização em serviços de domínio.

---

## Funcionalidades Obrigatórias

### 1. Modelagem com Lombok
- Criar as seguintes classes:
    - `Product` → `{ id, title, price }`
    - `Todo` → `{ id, todo, completed, userId }`
    - *(Opcional)* `User` → `{ id, firstName, lastName }`
- Utilizar as anotações:
    - `@Data`
    - `@NoArgsConstructor`
    - `@AllArgsConstructor`

### 2. DTOs de Resposta (Wrappers)
- `ProductListResponse` → `{ List<Product> products, int total, int skip, int limit }`
- `TodoListResponse` → `{ List<Todo> todos, int total, int skip, int limit }`

### 3. Cliente HTTP
- Implementar utilitário para métodos:
    - `GET`, `POST`, `PUT`, `DELETE`
- Requisitos:
    - Enviar/receber JSON
    - Tratar status HTTP: se não for 2xx, exibir mensagem de erro amigável

### 4. Serviço de Domínio

#### ProductService
- `list(limit, skip)` → retorna `List<Product>`
- `search(q)` → retorna `List<Product>`

#### TodoService
- `list(limit, skip)` → retorna `List<Todo>`
- `add(text, userId)` → retorna `Todo` criado
- `toggle(id, completed)` → retorna `Todo` atualizado
- `delete(id)` → retorna `boolean` (sucesso)

### 5. Apresentação no Console
- Produtos: imprimir no formato → `id | title | price`
- Tarefas: imprimir no formato → `id | todo | (OK/PEND) | user={userId}`
- Mensagens claras de sucesso/erro para cada ação

---

##  Requisitos de Qualidade

- Tratamento de erros:
    - IO
    - JSON inválido
    - Status HTTP ≠ 2xx
    - Entradas vazias
- Código legível:
    - Nomes claros
    - `toString()` útil nas entidades
    - Mensagens amigáveis ao usuário
- Build:
    - fornecer build.gradle ou pom.xml com Jackson e Lombok    
---



