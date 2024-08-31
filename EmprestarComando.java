import java.util.Date;
class EmprestarComando implements Comando {


    @Override
    public void executar(Parametros parametros) {

        Repositorio repositorio = parametros.getRepositorio();

        int codigoLivro = parametros.getCodigoLivro();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        IRegraEmprestimo regraEmprestimo = usuario.getRegraEmprestimo();
        ResultadoEmprestimo resultado = regraEmprestimo.podeEmprestar(livro, usuario);


        if (resultado.podeEmprestar()) {
            Exemplar exemplarEmprestado = livro.emprestarExemplar();
            Emprestimo emprestimo = new Emprestimo(usuario, livro, exemplarEmprestado,
                    new Date(),
                    new Date(
                            System.currentTimeMillis() + usuario.getPrazoDias() * 24 * 60 * 60 * 1000));

            usuario.adicionarEmprestimo(emprestimo);
            livro.removerReserva(usuario);
            usuario.removerReserva(livro);

            resultado.printar();
            System.out.println("Empréstimo realizado: " + usuario.getNome() + " pegou o livro: " + livro.getTitulo());
        }else{
            resultado.printar();
        }

    }


}