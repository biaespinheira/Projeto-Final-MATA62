class RegraEmprestimoAluno implements IRegraEmprestimo {
    
    @Override
    public boolean podeEmprestar(Livro livro, Usuario usuario) {

        boolean disponivel = livro.temExemplarDisponivel();
        //System.out.println("Disponível: " + disponivel);

        boolean naoDevedor = true;
        for (Emprestimo emprestimo : usuario.getEmprestimos()) {
            if (emprestimo.isAtrasado()) {
                naoDevedor = false;
                break;
            }
        }

        boolean abaixoLimite = usuario.getEmprestimos().size() < usuario.getLimiteLivros();
        boolean temReserva = livro.temReserva(usuario);
        //essa variavel deve ser nomeada somente semReserva, não?
        boolean disponivelSemReserva = livro.getQtdDisponiveis() > livro.getQtdReservas();
        boolean jaEmprestado = usuario.temEmprestimo(livro);
        boolean podeEmprestar = disponivel && naoDevedor && abaixoLimite && (temReserva || disponivelSemReserva) && !jaEmprestado;


        if(podeEmprestar){
            System.out.println("Estudante " + usuario.getNome() + " pode pegar o livro!");
        }
        if(!disponivel){
            System.out.println("Estudante " + usuario.getNome() + " não pode pegar o livro pois está devedor!");
        }
        if(!naoDevedor){
            System.out.println("Estudante " + usuario.getNome() + " não pode pegar o livro pois não tem exemplares disponíveis!");
        }
        if(!abaixoLimite){
            System.out.println("Estudante " + usuario.getNome() + " não pode pegar o livro pois ultrapassou o limite de livros emprestados!");
        }
        if(jaEmprestado){
            System.out.println("Estudante " + usuario.getNome() + " não pode pegar o livro pois já tem "+ livro.getTitulo() + " emprestado!");
        }
        if(!(temReserva || disponivelSemReserva) ){
            System.out.println("Estudante " + usuario.getNome() + " não pode pegar o livro pois não tem reserva!");
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