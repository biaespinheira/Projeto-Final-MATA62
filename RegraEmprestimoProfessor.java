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
            mensagem = "Professor " + usuario.getNome() + " pode pegar o livro!\n";
        }
        if (!isNaoDevedor()) {
            mensagem += "Professor " + usuario.getNome() + " não pode pegar o livro pois está devedor!\n";
        }
        if(!isDisponivel()){
            mensagem += "Professor " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!\n";
        }

        return new ResultadoEmprestimo(podeEmprestar, mensagem);

    }
}

