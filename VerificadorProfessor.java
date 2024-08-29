class VerificadorProfessor implements IVerificadorEmprestimos {
    @Override
    public boolean verificarDisponibilidade(Livro livro, Usuario usuario) {
        boolean disponivel = livro.temExemplarDisponivel();
        boolean naoDevedor = true;
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