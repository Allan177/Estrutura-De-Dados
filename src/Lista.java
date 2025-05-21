public class Lista<T> {

    private Item<T> primeiro;

    Lista() {
        this.primeiro = null;
    }

    public boolean isEmpty() {
        return this.primeiro == null;
    }

    public void append(T e) {
        if (isEmpty()) {
            this.primeiro = new Item<T>(e);
        } else {

            Item<T> corrente = this.primeiro;
            while (corrente.getProximo() != null) {
                corrente = corrente.getProximo();
            }
            corrente.setProximo( new Item<T>(e) );
        }
    }

    public void insert(T e, int i) throws Exception {

        if (i < 0) {

            throw new Exception("Posição inválida!");
        } else if (i == 0) {

            Item<T> novo = new Item<T>(e);
            novo.setProximo(this.primeiro);
            this.primeiro = novo;
        } else {

            Item<T> corrente = this.primeiro;
            int j = 0;
            while (j < i-1 && corrente.getProximo() != null) {
                corrente = corrente.getProximo();
                j++;
            }

            if (j == i-1) {
                Item<T> novo = new Item<T>(e);
                novo.setProximo(corrente.getProximo());
                corrente.setProximo(novo);
            } else {
                throw new Exception("Posição inválida!");
            }
        }
    }

    public void remove(T e) throws Exception{

        if ( this.isEmpty() ) {
            throw new Exception("Elemento não encontrado!");
        }

        if (this.primeiro.getValor().equals(e)) {
            this.primeiro = this.primeiro.getProximo();
        } else {

            Item<T> corrente = this.primeiro;
            while (corrente.getProximo() != null && !corrente.getProximo().getValor().equals(e)) {
                corrente = corrente.getProximo();
            }

            if (corrente.getProximo() == null) {
                throw new Exception("Elemento não encontrado!");
            }

            corrente.setProximo(corrente.getProximo().getProximo());
        }


    }

    public T delete(int i) throws Exception {

        if (i < 0 || this.primeiro == null) {
            throw new Exception("Posição inválida!");
        }

        if (i == 0) {
            T x = this.primeiro.getValor();
            this.primeiro = this.primeiro.getProximo();
            return x;
        } else {

            Item<T> corrente = this.primeiro;
            int j = 0;

            while (j < i-1 && corrente != null) {
                corrente = corrente.getProximo();
                j++;
            }

            if (corrente == null || corrente.getProximo() == null) {
                throw new Exception("Posição inválida!");
            }

            T x = corrente.getProximo().getValor();
            corrente.setProximo(corrente.getProximo().getProximo());
            return x;
        }
    }

    public int size() {

        int cont = 0;
        Item<T> corrente = this.primeiro;
        while (corrente != null) {
            cont++;
            corrente = corrente.getProximo();
        }

        return cont;
    }

    public void clear() {

        this.primeiro = null;
    }

    public String toString() {

        StringBuilder str = new StringBuilder();
        Item<T> corrente = this.primeiro;
        while (corrente != null) {
            str.append(corrente.getValor()).append(" ");
            corrente = corrente.getProximo();
        }
        return str.toString();
    }

}
