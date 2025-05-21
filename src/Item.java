public class Item<T> {

    private T valor;
    private Item<T> proximo;

    Item(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public T getValor() {

        return this.valor;
    }

    public Item<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(Item<T> proximo) {
        this.proximo = proximo;
    }
}