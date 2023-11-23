public abstract class ProdutoAbstract {
    private String nome;
    private double preco;

    public ProdutoAbstract(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String nomeProduto() {

        return nome;
    }

    public double valorProduto() {
        return preco;
    }

    public abstract String getTipo();
}