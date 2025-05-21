public class ListaEncadeamentoDuplo<T> {

    private ItemDuplo<T> primeiro;

    ListaEncadeamentoDuplo() {
        this.primeiro = null;
    }

    public boolean isEmpty() {
        return this.primeiro == null;
    }

    public void append(T e) {
        if (isEmpty()) {
            this.primeiro = new ItemDuplo<>(e);
        } else {

            ItemDuplo<T> corrente = this.primeiro;
            while (corrente.getProximo() != null) {
                corrente = corrente.getProximo();
            }
            corrente.setProximo( new ItemDuplo<>(e) );
            corrente.getProximo().setAnterior(corrente);
        }
    }

    public void insert(T e, int i) throws Exception {

        if (i < 0) {

            throw new Exception("Posição inválida!");
        } else if (i == 0) {

            ItemDuplo<T> novo = new ItemDuplo<T>(e);
            novo.setProximo(this.primeiro);
            this.primeiro.setAnterior(novo);
            this.primeiro = novo;
        } else {

            ItemDuplo<T> corrente = this.primeiro;
            int j = 0;
            while (j < i-1 && corrente.getProximo() != null) {
                corrente = corrente.getProximo();
                j++;
            }

            if (j == i-1) {
                ItemDuplo<T> novo = new ItemDuplo<T>(e);
                novo.setAnterior(corrente);
                novo.setProximo(corrente.getProximo());
                novo.getProximo().setAnterior(novo);
                corrente.setProximo(novo);
            } else {
                throw new Exception("Posição inválida!");
            }
        }
    }

    private ItemDuplo<T> search(T e) throws Exception {

        if (this.isEmpty()) {
            throw new Exception("Elemento não encontrado!");
        }

        ItemDuplo<T> corrente = this.primeiro;

        while (!corrente.getValor().equals(e) && corrente.getProximo() != null) {
            corrente = corrente.getProximo();
        }

        if (!corrente.getValor().equals(e)) {
            throw new Exception("Elemento não encontrado!");
        }

        return corrente;
    }

    public void remove(T e) throws Exception {

        ItemDuplo<T> corrente = search(e);

        if (corrente.getAnterior() == null) {

            this.primeiro = corrente.getProximo();
            this.primeiro.setAnterior(null);
        } else {

            corrente = corrente.getAnterior();
            if (corrente.getProximo().getProximo() != null) {
                corrente.getProximo().getProximo().setAnterior(corrente);
            }
            corrente.setProximo(corrente.getProximo().getProximo());
        }
    }

    /* public void remove(T e) throws Exception{

        if ( this.isEmpty() ) {
            throw new Exception("Elemento não encontrado!");
        }

        if (this.primeiro.getValor().equals(e)) {
            this.primeiro = this.primeiro.getProximo();
            this.primeiro.setAnterior(null);
        } else {

            ItemDuplo<T> corrente = this.primeiro;
            while (corrente.getProximo() != null && !corrente.getValor().equals(e)) {
                corrente = corrente.getProximo();
            }

            if (!corrente.getValor().equals(e)) {
                throw new Exception("Elemento não encontrado!");
            }

            corrente = corrente.getAnterior();
            if (corrente.getProximo().getProximo() != null) {
                corrente.getProximo().getProximo().setAnterior(corrente);
            }
            corrente.setProximo(corrente.getProximo().getProximo());

        }


    } */

    public T delete(int i) throws Exception {

        if (i < 0 || this.primeiro == null) {
            throw new Exception("Posição inválida!");
        }

        if (i == 0) {
            T x = this.primeiro.getValor();
            this.primeiro = this.primeiro.getProximo();
            this.primeiro.setAnterior(null);
            return x;
        } else {

            ItemDuplo<T> corrente = this.primeiro;
            int j = 0;

            while (j < i && corrente != null) {
                corrente = corrente.getProximo();
                j++;
            }

            if (corrente == null) {
                throw new Exception("Posição inválida!");
            }

            T x = corrente.getValor();
            corrente = corrente.getAnterior();
            if (corrente.getProximo().getProximo() != null) {
                corrente.getProximo().getProximo().setAnterior(corrente);
            }
            corrente.setProximo(corrente.getProximo().getProximo());
            return x;
        }
    }

    public int size() {

        int cont = 0;
        ItemDuplo<T> corrente = this.primeiro;
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
        ItemDuplo<T> corrente = this.primeiro;
        while (corrente != null) {
            str.append(corrente.getValor()).append(" ");
            corrente = corrente.getProximo();
        }
        return str.toString();
    }

}