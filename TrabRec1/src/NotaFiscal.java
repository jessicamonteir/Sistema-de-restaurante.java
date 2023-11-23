import java.util.ArrayList;

public class NotaFiscal {
    private ArrayList<Calculo> itens;
    private String nomeCliente;

    public NotaFiscal(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ProdutoAbstract item, int quantidade) {
        Calculo pedidoItem = new Calculo(item, quantidade);
        this.itens.add(pedidoItem);
    }

    public void exibirNotaFiscal() {
        System.out.println("\nNota Fiscal de " + nomeCliente + ":");
        double total = 0;

        for (Calculo pedidoItem : itens) {
            System.out.println(pedidoItem.toString());
            total += pedidoItem.calcularSubtotal();
        }

        double taxaServico = total * 0.10;
        double valorTotal = total + taxaServico;

        System.out.println("Taxa de Serviço (10%): R$" + taxaServico);
        System.out.println("Total do Pedido: R$" + valorTotal);
    }

    public double calcularTotalPedido() {
        double total = 0;
        for (Calculo pedidoItem : itens) {
            total += pedidoItem.calcularSubtotal();
        }
        return total + total * 0.10;
    }
}
