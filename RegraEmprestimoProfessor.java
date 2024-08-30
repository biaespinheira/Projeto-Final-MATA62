class RegraEmprestimoProfessor implements IRegraEmprestimo {
    @Override
    
    public boolean podeEmprestar(Livro livro, Usuario usuario) {
        boolean disponivel = livro.temExemplarDisponivel();
        boolean naoDevedor = true;

        // talvez fazer isso dentro de usuario;
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                naoDevedor = false;
                break;
            }
        }
        
        boolean podeEmprestar = disponivel && naoDevedor;

        System.out.println("Professor " + usuario.getNome() + " pode emprestar o livro? " + podeEmprestar);
        return podeEmprestar;
    }
}