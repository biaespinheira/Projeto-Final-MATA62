class ConsultarNotificacoesComando implements Comando {
    @Override
    public void executar(Parametros parametros){

        ConsoleIO console = ConsoleIO.getInstancia();
        Repositorio repositorio = parametros.getRepositorio();
        int codigoUsuario = parametros.getCodigoUsuario();
        
        Usuario usuario = repositorio.buscarUsuario(codigoUsuario);

        Observer observer = (Observer) usuario;

        console.mostrarMensagem("\n" + usuario.getNome() + " foi notificado "+ observer.getQtdNotificacoes()+ " vezes.\n");
    }
}