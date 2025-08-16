import service.ConversorMoedas;

import java.util.List;
import java.util.Scanner;

public class PontoDeEntrada {
    private static final List<OpcaoConversao> CONVERSOES = List.of(
            new OpcaoConversao("USD", "BRL"),
            new OpcaoConversao("BRL", "USD"),
            new OpcaoConversao("EUR", "USD"),
            new OpcaoConversao("USD", "EUR"),
            new OpcaoConversao("GBP", "JPY"),
            new OpcaoConversao("AUD", "BRL")
    );
    private static final List<String> MOEDAS_SUPORTADAS = List.of("USD", "EUR", "BRL", "JPY", "GBP", "AUD");

    private record OpcaoConversao(String origem, String destino) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMoedas servico = new ConversorMoedas();

        while (true) {
            System.out.print(
                    """
                    
                    === Conversor de Moedas ===
                    Moedas disponíveis: %s
                    """.formatted(MOEDAS_SUPORTADAS)
            );

            for (int i = 0; i < CONVERSOES.size(); i++) {
                var opcao = CONVERSOES.get(i);
                System.out.println("%d. %s -> %s".formatted(i + 1, opcao.origem, opcao.destino));
            }
            System.out.println("%d. Sair".formatted(CONVERSOES.size() + 1));
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }

            if (opcao == CONVERSOES.size() + 1) {
                System.out.println("Encerrando o programa...");
                break;
            }

            if (opcao < 1 || opcao > CONVERSOES.size()) {
                System.out.println("Opção inválida! Escolha entre 1 e " + (CONVERSOES.size() + 1));
                continue;
            }

            System.out.print("Digite o valor a converter: ");
            double valor;
            try {
                valor = Double.parseDouble(scanner.nextLine());
                if (valor < 0) {
                    System.out.println("O valor não pode ser negativo!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido.");
                continue;
            }

            var conversao = CONVERSOES.get(opcao - 1);
            try {
                double resultado = servico.converterMoeda(conversao.origem, conversao.destino, valor);
                System.out.println(
                        """
                        %.2f %s = %.2f %s
                        """.formatted(valor, conversao.origem, resultado, conversao.destino)
                );
            } catch (Exception e) {
                System.out.println("Erro ao realizar a conversão: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
