class RegraEmprestimoAluno implements IRegraEmprestimo {
    
    @Override
    public boolean podeEmprestar(Livro livro, Usuario usuario) {

        ConsoleIO console = ConsoleIO.getInstancia();

        boolean podeEmprestar = true;

        boolean disponivel = livro.temExemplarDisponivel();

        boolean naoDevedor = true;
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                naoDevedor = false;
                break;
            }
        }

        boolean abaixoLimite = usuario.getEmprestimos().size() < usuario.getLimiteLivros();

        boolean temReserva = livro.temReserva(usuario);

        boolean disponivelSemReserva = livro.getQtdDisponiveis() > livro.getQtdReservas();

        boolean jaEmprestado = usuario.temEmprestimo(livro);

        podeEmprestar = disponivel && naoDevedor && abaixoLimite && (temReserva || disponivelSemReserva) && !jaEmprestado;

        if(!disponivel){
            console.mostrarMensagem("\nAluno " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!");
        }
        else if(!naoDevedor){
            console.mostrarMensagem("\nAluno " + usuario.getNome() + " não pode pegar o livro pois está devedor!");
        }
        else if(!abaixoLimite){
            console.mostrarMensagem("\nAluno " + usuario.getNome() + " não pode pegar o livro pois ultrapassou o limite de empréstimos!");
        }
        else if(jaEmprestado){
            console.mostrarMensagem("\nAluno " + usuario.getNome() + " não pode pegar o livro pois já tem "+ livro.getTitulo() + " emprestado!");
        }
        else if(!(temReserva || disponivelSemReserva) ){
            console.mostrarMensagem("\nAluno " + usuario.getNome() + " não pode pegar o livro pois não tem reserva!");
        }

        return podeEmprestar;
    }
}



// class RegraEmprestimoAluno implements IRegraEmprestimo {
    
//     @Override
//     public boolean podeEmprestar(Livro livro, Usuario usuario) {

//         boolean disponivel = livro.temExemplarDisponivel();

//         boolean naoDevedor = true;
//         for (Emprestimo emprestimo : usuario.getEmprestimos()) {
//             if (emprestimo.isAtrasado()) {
//                 naoDevedor = false;
//                 break;
//             }
//         }

//         boolean abaixoLimite = usuario.getEmprestimos().size() < usuario.getLimiteLivros();

//         boolean temReserva = livro.temReserva(usuario);

//         boolean disponivelSemReserva = livro.getQtdDisponiveis() < livro.getQtdReservas();

//         boolean podeEmprestar = disponivel && naoDevedor && abaixoLimite && (temReserva || disponivelSemReserva);

//         System.out.println("Usuário " + usuario.getNome() + " pode pegar emprestado? " + podeEmprestar);
//         return podeEmprestar;
//     }
// }