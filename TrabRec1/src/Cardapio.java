import java.util.HashMap;
import java.util.Map;

public class Cardapio {
    private Map<Integer, ProdutoAbstract> itens;

    public Cardapio() {
        this.itens = new HashMap<>();
        CardapioJ();
    }

    private void CardapioJ() {
        itens.put(1, new Produto("Temaki", 10.00));
        itens.put(2, new Produto("Sushi", 5.00));
        itens.put(3, new Produto("Hot Roll", 7.00));
    }

    public ProdutoAbstract escolherItem(int numeroItem) {
        return itens.get(numeroItem);
    }

    public int escolherNumeroItens() {
        return itens.size();
    }
}