class ConsultarLivroComando implements Comando {
    @Override
    public void executar(Parametros parametros) {

        ConsoleIO console = ConsoleIO.getInstancia();
        Repositorio repositorio = parametros.getRepositorio();

        // O código do livro é recuperado corretamente do parâmetro.
        int codigoLivro = parametros.getCodigoUsuario();
        Livro livro = repositorio.buscarLivro(codigoLivro);

        String informacoes="\n";

        informacoes+="Título: " + livro.getTitulo();
        informacoes+="\nQuantidade de reservas: " + livro.getQtdReservas()+"\n";


        for(Reserva reserva : livro.getReservas()) {
            informacoes+="\nNome da pessoa que reservou: " + reserva.getUsuario().getNome();
        }

        for (Exemplar exemplar : livro.getExemplares()){
            informacoes+="\nCódigo do exemplar: " + exemplar.getCodigo();

            String status = "Disponível";
            if (!exemplar.isDisponivel()){
                status="Emprestado para ";
                Emprestimo emprestimo = exemplar.getEmprestimo();
                status+= emprestimo.getUsuario().getNome();
                status+= "\nData do empréstimo: " + emprestimo.getDataEmprestimo();
                status+= " | Data de devolução: " + emprestimo.getDataDevolucao();
            }

            informacoes+=" | Status: "+ status + "\n";
        }

        console.mostrarMensagem(informacoes);

        }
}
