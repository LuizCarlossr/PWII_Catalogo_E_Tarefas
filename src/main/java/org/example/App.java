package org.example;

import org.example.model.Tarefa;
import org.example.service.ProdutoServico;
import org.example.service.TarefaServico;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoServico produtoServico = new ProdutoServico();
        TarefaServico tarefaServico = new TarefaServico();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Listar produtos");
            System.out.println("2. Buscar produtos");
            System.out.println("3. Listar tarefas");
            System.out.println("4. Adicionar tarefa");
            System.out.println("5. Marcar/Desmarcar tarefa");
            System.out.println("6. Remover tarefa");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Limit: ");
                        int limit = scanner.nextInt();
                        System.out.print("Skip: ");
                        int skip = scanner.nextInt();
                        scanner.nextLine();
                        produtoServico.listar(limit, skip)
                                .forEach(p -> System.out.println(p.getId() + " | " + p.getTitle() + " | " + p.getPrice()));
                    }
                    case 2 -> {
                        System.out.print("Buscar por: ");
                        String termo = scanner.nextLine();
                        produtoServico.buscar(termo)
                                .forEach(p -> System.out.println(p.getId() + " | " + p.getTitle() + " | " + p.getPrice()));
                    }
                    case 3 -> {
                        System.out.print("Limit: ");
                        int limit = scanner.nextInt();
                        System.out.print("Skip: ");
                        int skip = scanner.nextInt();
                        scanner.nextLine();
                        tarefaServico.listar(limit, skip)
                                .forEach(t -> System.out.println(t.getId() + " | " + t.getTodo() + " | " + (t.isCompleted() ? "OK" : "PEND") + " | user=" + t.getUserId()));
                    }
                    case 4 -> {
                        System.out.print("Texto da tarefa: ");
                        String texto = scanner.nextLine();
                        System.out.print("User ID: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine();
                        Tarefa nova = tarefaServico.adicionar(texto, userId);
                        System.out.println("Tarefa adicionada: " + nova);
                    }
                    case 5 -> {
                        System.out.print("ID da tarefa: ");
                        int id = scanner.nextInt();
                        System.out.print("Marcar como concluída? (true/false): ");
                        boolean completo = scanner.nextBoolean();
                        scanner.nextLine();
                        Tarefa atualizada = tarefaServico.marcar(id, completo);
                        System.out.println("Tarefa atualizada: " + atualizada);
                    }
                    case 6 -> {
                        System.out.print("ID da tarefa a remover: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        boolean sucesso = tarefaServico.remover(id);
                        System.out.println(sucesso ? "Tarefa removida com sucesso." : "Erro ao remover tarefa.");
                    }
                    case 7 -> {
                        System.out.println("Encerrando...");
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}

