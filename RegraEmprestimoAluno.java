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
        boolean disponivelSemReserva = livro.getQtdExemplaresDisponiveis() > livro.getQtdReservas();
        boolean jaEmprestado = usuario.temEmprestimo(livro);
        boolean qtdReservasQtdExemplares = livro.getQtdReservas()<livro.getQtdExemplaresDisponiveis();
        boolean podeEmprestar = isDisponivel() && isNaoDevedor() && abaixoLimite && (temReserva || disponivelSemReserva) && !jaEmprestado;

        String mensagem = "";
        if (podeEmprestar) {
            mensagem = "Estudante " + usuario.getNome() + " pode pegar o livro!";
        }
        else{
            if (!isNaoDevedor()) {

                mensagem += "Estudante " + usuario.getNome() + " não pode pegar o livro pois está devedor!\n";
            }
          if (!isDisponivel()) {
            mensagem += "Estudante " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!\n";
        }  if (!abaixoLimite) {
            mensagem += "Estudante " + usuario.getNome() + " não pode pegar o livro pois ultrapassou o limite de livros emprestados!\n";
        }  if (jaEmprestado) {
            mensagem += "Estudante " + usuario.getNome() + " não pode pegar o livro pois já tem " + livro.getTitulo() + " emprestado!\n";
        } if(!(temReserva || disponivelSemReserva) ){
            mensagem += "Estudante " + usuario.getNome() + " não pode pegar o livro pois não tem reserva!\n";
        }

    }

        return new ResultadoEmprestimo(podeEmprestar, mensagem);
    }
}





