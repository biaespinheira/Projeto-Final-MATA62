class Exemplar {
    private int codigoExemplar;
    private boolean disponivel;
    private Emprestimo emprestimo;
    public Exemplar(int codigoExemplar) {

        this.codigoExemplar = codigoExemplar;
        this.disponivel = true;
    }

    public void setEmprestimo(Emprestimo emprestimo){
        this.emprestimo = emprestimo;
    }
    public Emprestimo getEmprestimo(){
        return emprestimo;
    }

    public int getCodigoExemplar() {
        return codigoExemplar;
    }

    public boolean isDisponivel() {
        return emprestimo == null;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = emprestimo != null;
    }
}