class Exemplar {
    private int codigoExemplar;
    private Emprestimo emprestimo;
    private Livro livro;

    public Exemplar(int codigoExemplar, Livro livro) {
        this.codigoExemplar = codigoExemplar;
        this.emprestimo=null;
        this.livro=livro;
    }

    public Livro getLivro(){
        return this.livro;
    }

    public int getCodigo() {
        return codigoExemplar;
    }

    public boolean isDisponivel() {
        return emprestimo == null;
    }

    public void emprestar(Emprestimo emprestimo){
        this.emprestimo=emprestimo;
    }

    public void devolver(){
        this.emprestimo=null;
    }

    public Emprestimo getEmprestimo(){
        return this.emprestimo;
    }
}