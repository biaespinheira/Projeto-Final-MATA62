class RegistrarObservadorComando implements Comando {

    @Override
    public void executar(Parametros parametros) {
        Livro livro = parametros.getLivro();
        Usuario usuario = parametros.getUsuario();
        Observer observador = (Observer) parametros.getUsuario();

        livro.registrarObservador(observador);
        System.out.println(usuario.getNome() + " registrado como observador do livro " + livro.getTitulo());
    }
}