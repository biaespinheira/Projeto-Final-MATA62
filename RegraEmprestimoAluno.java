class RegraEmprestimoAluno implements IRegraEmprestimo {
    
    @Override
    public boolean podeEmprestar(Livro livro, Usuario usuario) {

        boolean disponivel = livro.temExemplarDisponivel();
        System.out.println("Disponível: " + disponivel);

        boolean naoDevedor = true;
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                naoDevedor = false;
                break;
            }
        }
        System.out.println("Não devedor: " + naoDevedor);

        boolean abaixoLimite = usuario.getEmprestimos().size() < usuario.getLimiteLivros();
        System.out.println("Abaixo do limite de empréstimos: " + abaixoLimite);

        boolean temReserva = livro.temReserva(usuario);
        System.out.println("Usuário tem reserva: " + temReserva);

        boolean disponivelSemReserva = livro.getQtdDisponiveis() > livro.getQtdReservas();
        System.out.println("Disponível sem reserva: " + disponivelSemReserva);

        boolean jaEmprestado = usuario.temEmprestimo(livro);
        System.out.println("Ja tem empréstimo do livro: " + jaEmprestado);

        boolean podeEmprestar = disponivel && naoDevedor && abaixoLimite && (temReserva || disponivelSemReserva) && !jaEmprestado;
        System.out.println("Usuário " + usuario.getNome() + " pode pegar emprestado? " + podeEmprestar);
        
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