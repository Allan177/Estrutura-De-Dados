public class ItemDuplo<T> {

    private T valor;
    private ItemDuplo<T> anterior;
    private ItemDuplo<T> proximo;

    ItemDuplo(T valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }

    public T getValor() {

        return this.valor;
    }

    public ItemDuplo<T> getAnterior() {
        return this.anterior;
    }

    public void setAnterior(ItemDuplo<T> anterior) {
        this.anterior = anterior;
    }

    public ItemDuplo<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(ItemDuplo<T> proximo) {
        this.proximo = proximo;
    }
}
