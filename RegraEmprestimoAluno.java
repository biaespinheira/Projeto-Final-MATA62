class RegraEmprestimoAluno implements IRegraEmprestimo {
    
    @Override
    public boolean podeEmprestar(Livro livro, Usuario usuario) {
        boolean disponivel = livro.temExemplarDisponivel();
        boolean naoDevedor = true;
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                naoDevedor = false;
                break;
            }
        }
        boolean abaixoLimite = usuario.getEmprestimos().size() < usuario.getLimiteLivros();
        boolean podeEmprestar = disponivel && naoDevedor && abaixoLimite;

        System.out.println("Usuário " + usuario.getNome() + " pode pegar emprestado? " + podeEmprestar);
        return podeEmprestar;
    }
}