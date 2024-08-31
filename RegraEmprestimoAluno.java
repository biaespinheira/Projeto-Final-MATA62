class RegraEmprestimoAluno extends RegraEmprestimo implements IRegraEmprestimo {

    public RegraEmprestimoAluno(Boolean disponivel, Boolean naoDevedor) {
        super(disponivel, naoDevedor);
    }

    @Override
    public ResultadoEmprestimo podeEmprestar(Livro livro, Usuario usuario) {
        setNaoDevedor(true);
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                setNaoDevedor(false);
                break;
            }
        }

        setDisponivel(livro.temExemplarDisponivel());
        boolean abaixoLimite = usuario.getEmprestimos().size() < usuario.getLimiteLivros();
        boolean temReserva = livro.temReserva(usuario);
        boolean disponivelSemReserva = livro.getQtdDisponiveis() > livro.getQtdReservas();
        boolean jaEmprestado = usuario.temEmprestimo(livro);
        boolean podeEmprestar = isDisponivel() && isNaoDevedor() && abaixoLimite && (temReserva || disponivelSemReserva) && !jaEmprestado;

        String mensagem = "";
        if (podeEmprestar) {
            mensagem = "Estudante " + usuario.getNome() + " pode pegar o livro!";
        }  if (!isNaoDevedor()) {
            mensagem = "Estudante " + usuario.getNome() + " não pode pegar o livro pois está devedor!";
        }  if (!isDisponivel()) {
            mensagem = "Estudante " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!";
        }  if (!abaixoLimite) {
            mensagem = "Estudante " + usuario.getNome() + " não pode pegar o livro pois ultrapassou o limite de livros emprestados!";
        }  if (jaEmprestado) {
            mensagem = "Estudante " + usuario.getNome() + " não pode pegar o livro pois já tem " + livro.getTitulo() + " emprestado!";
        } if(!(temReserva || disponivelSemReserva) ){
            mensagem = "Estudante " + usuario.getNome() + " não pode pegar o livro pois não tem reserva!";
        }

        return new ResultadoEmprestimo(podeEmprestar, mensagem);
    }
}





