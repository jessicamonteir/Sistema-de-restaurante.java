public class Calculo {
    private ProdutoAbstract item;
    private int quantidade;

    public Calculo(ProdutoAbstract item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return item.valorProduto() * quantidade;
    }

    public String toString() {
        return item.nomeProduto() + " - Quantidade: " + quantidade + " - Subtotal: R$" + calcularSubtotal();
    }
}
