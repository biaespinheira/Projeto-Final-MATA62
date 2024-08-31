class RegraEmprestimoProfessor extends RegraEmprestimo implements IRegraEmprestimo {
    public RegraEmprestimoProfessor(Boolean disponivel, Boolean naoDevedor) {
        super(disponivel, naoDevedor);
    }
    @Override
    public ResultadoEmprestimo podeEmprestar(Livro livro, Usuario usuario) {
        setDisponivel(livro.temExemplarDisponivel());
        setNaoDevedor(true);

        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                setNaoDevedor(false);
                break;
            }
        }

        boolean podeEmprestar = isDisponivel() && isNaoDevedor();
        String mensagem = "";

        if (podeEmprestar) {
            mensagem = "Professor " + usuario.getNome() + " pode pegar o livro!";
        }
        if (!isNaoDevedor()) {
            mensagem = "Professor " + usuario.getNome() + " não pode pegar o livro pois está devedor!";
        }
        if(!isDisponivel()){
            mensagem = "Professor " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!";
        }

        return new ResultadoEmprestimo(podeEmprestar, mensagem);

    }
}

