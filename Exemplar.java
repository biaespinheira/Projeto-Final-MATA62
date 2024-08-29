class Exemplar {
    private int codigoExemplar;
    private boolean disponivel;
    // preciso de um atributo do tipo emprestimo para saber se está emprestado e a partir disso saber também qual usuário está com o livro

    public Exemplar(int codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
        this.disponivel = true;
    }

    public int getCodigoExemplar() {
        return codigoExemplar;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}