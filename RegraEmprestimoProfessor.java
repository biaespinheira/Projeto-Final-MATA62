class RegraEmprestimoProfessor  implements IRegraEmprestimo {

    @Override
    public ResultadoEmprestimo podeEmprestar(Livro livro, Usuario usuario) {
        Boolean disponivel = livro.temExemplarDisponivel();

        Boolean naoDevedor = true;
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                naoDevedor = false;
                break;
            }
        }

        boolean podeEmprestar = disponivel && naoDevedor;
        String mensagem = "";

        if (podeEmprestar) {
            mensagem = "Professor " + usuario.getNome() + " pode pegar o livro!";
        }
        if (!naoDevedor) {
            mensagem += "Professor " + usuario.getNome() + " não pode pegar o livro pois está devedor!\n";
        }
        if(!disponivel){
            mensagem += "Professor " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!";
        }

        return new ResultadoEmprestimo(podeEmprestar, mensagem);

    }
}

