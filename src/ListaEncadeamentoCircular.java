public class ListaEncadeamentoCircular<T> {

    private ItemDuplo<T> primeiro;
    private int tamanho;

    ListaEncadeamentoCircular() {

        this.primeiro = null;
        this.tamanho = 0;
    }

    public boolean isEmpty() {

        return this.primeiro == null;
    }

    public void append(T e) {
        if (isEmpty()) {
            this.primeiro = new ItemDuplo<>(e);
            this.primeiro.setProximo(this.primeiro);
            this.primeiro.setAnterior(this.primeiro);
        } else {

            ItemDuplo<T> novo = new ItemDuplo<T>(e);
            novo.setAnterior(this.primeiro.getAnterior());
            novo.setProximo(this.primeiro);
            this.primeiro.getAnterior().setProximo(novo);
            this.primeiro.setAnterior(novo);
        }

        tamanho++;
    }

    public void insert(T e, int i) throws Exception {

        if (i < 0) {

            throw new Exception("Posição inválida!");
        } else if (i == 0 && size() == 0) {

            ItemDuplo<T> novo = new ItemDuplo<T>(e);
            novo.setAnterior(novo);
            novo.setProximo(novo);
            this.primeiro = novo;

        } else if (i == 0) {

            ItemDuplo<T> novo = new ItemDuplo<T>(e);
            novo.setAnterior(this.primeiro.getAnterior());
            novo.setProximo(this.primeiro);
            this.primeiro.getAnterior().setProximo(novo);
            this.primeiro.setAnterior(novo);
            this.primeiro = novo;
        } else {

            if (i > size()) {
                throw new Exception("Posição inválida!");
            }

            ItemDuplo<T> corrente = this.primeiro;
            int j = 0;
            while (j < i-1) {
                corrente = corrente.getProximo();
                j++;
            }

            ItemDuplo<T> novo = new ItemDuplo<T>(e);
            novo.setAnterior(corrente);
            novo.setProximo(corrente.getProximo());
            novo.getProximo().setAnterior(novo);
            corrente.setProximo(novo);
        }

        tamanho++;
    }

    private ItemDuplo<T> search(T e) throws Exception {

        if (this.isEmpty()) {
            throw new Exception("Elemento não encontrado!");
        }

        ItemDuplo<T> corrente = this.primeiro;

        while (!corrente.getValor().equals(e) && corrente.getProximo() != this.primeiro) {
            corrente = corrente.getProximo();
        }

        if (!corrente.getValor().equals(e)) {
            throw new Exception("Elemento não encontrado!");
        }

        return corrente;
    }

    public void remove(T e) throws Exception {

        ItemDuplo<T> excluindo = search(e);
        ItemDuplo<T> corrente = excluindo.getAnterior();

        corrente.setProximo(excluindo.getProximo());
        excluindo.getProximo().setAnterior(corrente);

        if (excluindo == this.primeiro) {
            this.primeiro = excluindo.getProximo();
        }

        tamanho--;
    }

    public T delete(int i) throws Exception {

        if (this.primeiro == null || i < 0 || i >= tamanho) {
            throw new Exception("Posição inválida!");
        }

        if (i == 0 && tamanho == 1) {
            T x = this.primeiro.getValor();
            this.primeiro = null;
            tamanho--;
            return x;
        } else {

            ItemDuplo<T> corrente = this.primeiro;
            int j = 0;

            while (j < i) {
                corrente = corrente.getProximo();
                j++;
            }

            T x = corrente.getValor();
            ItemDuplo<T> excluindo = corrente;
            corrente = corrente.getAnterior();
            corrente.setProximo(excluindo.getProximo());
            excluindo.getProximo().setAnterior(corrente);

            if (excluindo == this.primeiro) {
                this.primeiro = this.primeiro.getProximo();
            }
            tamanho--;
            return x;
        }
    }

    public T get(int i) throws Exception {

        if (this.primeiro == null || i < 0 || i >= tamanho) {
            throw new Exception("Posição inválida!");
        }

        ItemDuplo<T> corrente = this.primeiro;
        int j = 0;

        while (j < i) {
            corrente = corrente.getProximo();
            j++;
        }

        return corrente.getValor();
    }

    public int size() {

        return tamanho;
    }

    public void clear() {

        this.primeiro = null;
        this.tamanho = 0;
    }

    public String toString() {

        StringBuilder str = new StringBuilder();
        ItemDuplo<T> corrente = this.primeiro;
        while (corrente.getProximo() != this.primeiro) {
            str.append(corrente.getValor()).append(" ");
            corrente = corrente.getProximo();
        }
        str.append(corrente.getValor()).append(" ");
        return str.toString();
    }

}