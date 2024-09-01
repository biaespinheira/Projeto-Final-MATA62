class Professor extends Usuario implements Observer{

    private int qtdNotificacoes; 

    public Professor(String nome, int codigo, IRegraEmprestimo regraEmprestimo ) {
        super(nome, codigo, regraEmprestimo, 7, Integer.MAX_VALUE);
        this.qtdNotificacoes=0;
    }

    @Override
    public void notificar(){
        this.qtdNotificacoes+=1;
    }

    @Override
    public int getQtdNotificacoes(){
        return this.qtdNotificacoes;
    }
}