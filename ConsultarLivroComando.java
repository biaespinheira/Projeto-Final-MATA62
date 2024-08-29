class ConsultarLivroComando implements Comando {
    @Override
    public void executar(Parametros parametros) {
        Livro livro = parametros.getLivro();
        System.out
                .println("Título: " + livro.getTitulo() + ", Exemplares Disponíveis: " + livro.temExemplarDisponivel());
    }
}