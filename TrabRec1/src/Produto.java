public class Produto extends ProdutoAbstract {
    public Produto(String nome, double preco) {
        super(nome, preco);
    }
    @Override
    public String tipo() {
        return "Produtos";
    }
}
