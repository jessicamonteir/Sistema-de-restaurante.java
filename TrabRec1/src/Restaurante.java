import java.util.Scanner;
import java.text.DecimalFormat;


public class Restaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cardapio cardapio = new Cardapio();
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    fazerPedido(scanner, cardapio);
                    break;
                case 2:
                    System.out.println("Programa encerrado. Volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 2);
    }

    private static void fazerPedido(Scanner scanner, Cardapio cardapio) {
        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.next();

        NotaFiscal pedido = new NotaFiscal(nomeCliente);

        exibirCardapio(cardapio);

        while (true) {
            System.out.println("Digite o número do item desejado, depois 0 para finalizar o pedido: ");
            int numeroItem = scanner.nextInt();

            if (numeroItem == 0) {
                pedido.exibirNotaFiscal();
                processarPagamento(scanner, pedido);
                break;
            } else {
                ProdutoAbstract item = cardapio.escolherItem(numeroItem);
                if (item != null) {
                    System.out.print("Digite a quantidade desejada: ");
                    int quantidade = scanner.nextInt();
                    pedido.adicionarItem(item, quantidade);
                } else {
                    System.out.println("Item inválido. Tente novamente.");
                }
            }
        }
    }

    private static void exibirCardapio(Cardapio cardapio) {
        System.out.println("\nCardápio:");
        Produto produto = new Produto("Sushi", 5.0);
        System.out.println(produto.tipo());

        for (int i = 1; i <= cardapio.escolherNumeroItens(); i++) {
            ProdutoAbstract item = cardapio.escolherItem(i);
            System.out.println(i + ". " + item.nomeProduto() + " - R$" + item.valorProduto());
        }
    }

    private static void processarPagamento(Scanner scanner, NotaFiscal pedido) {
        while (true) {
            System.out.print("Digite o valor recebido em dinheiro: R$");
            double valorRecebido = scanner.nextDouble();

            double troco = valorRecebido - pedido.calcularTotalPedido();

            if (troco >= 0) {
                DecimalFormat df = new DecimalFormat("0.00");
                System.out.println("Troco: R$" + df.format(troco));
                System.out.println("Volte sempre!!");
                System.out.println("<3");
                break;
            } else {
                System.out.println("Valor insuficiente. O valor recebido não cobre o total do seu pedido.");
                System.out.println(":(");
                System.out.println("Deseja pagar novamente?");
                System.out.println("1. Sim");
                System.out.println("2. Encerrar pedido");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        break;
                    case 2:
                        System.out.println("Pedido encerrado. Volte sempre!");
                        return;
                    default:
                        System.out.println("Opção inválida. Encerrandp o pedido.");
                        return;
                }
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\nBem vindo ao restaurante japônes sem Tempurá");
        System.out.println("1. Fazer Pedido");
        System.out.println("2. Sair");
        System.out.print("Escolha a opção desejada: ");
    }
}
