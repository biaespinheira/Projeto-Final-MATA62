class RegistrarObservadorComando implements Comando {

    @Override
    public void executar(Parametros parametros) {
        Repositorio repositorio = parametros.getRepositorio();

        int codigoLivro = parametros.getCodigoLivro();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        int codigoUsuario = parametros.getCodigoUsuario();
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        Observer observador = (Observer) usuario;

        livro.registrarObservador(observador);
        System.out.println(usuario.getNome() + " registrado como observador do livro " + livro.getTitulo());
    }
}