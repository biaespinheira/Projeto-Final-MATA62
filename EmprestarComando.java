import java.util.Date;
class EmprestarComando implements Comando {


    @Override
    public void executar(Parametros parametros) {

        ConsoleIO console = ConsoleIO.getInstancia();
        Repositorio repositorio = parametros.getRepositorio();

        int codigoLivro = parametros.getCodigoLivro();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        IRegraEmprestimo regraEmprestimo = usuario.getRegraEmprestimo();

        if (regraEmprestimo.podeEmprestar(livro, usuario)) {
            Exemplar exemplarEmprestado = livro.emprestarExemplar();
            Emprestimo emprestimo = new Emprestimo(usuario, livro, exemplarEmprestado,
                    new Date(),
                    new Date(
                            System.currentTimeMillis() + usuario.getPrazoDias() * 24 * 60 * 60 * 1000));
            exemplarEmprestado.emprestar(emprestimo);
            livro.adicionarExemplar(exemplarEmprestado);
            usuario.adicionarEmprestimo(emprestimo);
            livro.removerReserva(usuario);
            usuario.removerReserva(livro);

            console.mostrarMensagem("\nEmpréstimo realizado: " + usuario.getNome() + " pegou o livro: " + livro.getTitulo()+ "\n");}
    }


}