import java.util.List;
import java.util.ArrayList;

abstract class Usuario {

  private int codigo; 
  private String nome;
  private int prazoDias;
  private int limiteLivros;
  private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

  private IRegraEmprestimo regraEmprestimo;
    
    // preciso de um metodo para verificar se um usuário já tem reservas para esse livro
  private List<Reserva> reservas = new ArrayList<Reserva>();

  public Usuario(String nome, int codigo, IRegraEmprestimo regraEmprestimo, int prazoDias, int limiteLivros) {
      this.nome = nome;
      this.codigo = codigo;
      this.prazoDias = prazoDias;
      this.limiteLivros = limiteLivros;
      this.regraEmprestimo = regraEmprestimo;
  }

  public String getNome() {
      return nome;
  }

  public int getCodigo() {
      return codigo;
  }

  public int getPrazoDias() {
      return prazoDias;
  }

  public int getLimiteLivros() {
      return limiteLivros;
  }

  public List<Emprestimo> getEmprestimos() {
      return emprestimos;
  }

  public List<Reserva> getReservas() {
      return reservas;
  }

  public void adicionarEmprestimo(Emprestimo emprestimo) {
      emprestimos.add(emprestimo);
  }

  public void adicionarReserva(Reserva reserva) {
      reservas.add(reserva);
  }

  public void removerReserva(Livro livro) {
      for (Reserva reserva : this.reservas){
        if (reserva.getLivro()==livro){
            this.reservas.remove(reserva);
            break;
        }
      }
  }

  public IRegraEmprestimo getRegraEmprestimo(){
    return this.regraEmprestimo;
  }

  public boolean temEmprestimo(Livro livro){
    for (Emprestimo emprestimo : this.emprestimos){
        if (emprestimo.getLivro()==livro){
            return true;
        }
    }
    return false;
  }

  public int qtdReservas(){
    return this.reservas.size();
  }

}

class Graduacao extends Usuario {
  public Graduacao(String nome, int codigo, IRegraEmprestimo regraEmprestimo) {
      super(nome, codigo, regraEmprestimo, 3, 3);
  }

}

class PosGraduacao extends Usuario {
  public PosGraduacao(String nome, int codigo, IRegraEmprestimo regraEmprestimo) {
      super(nome, codigo, regraEmprestimo, 5, 4);
  }

}

interface Observer {
    void notificar();
    int getQtdNotificacoes();
}

class Professor extends Usuario implements Observer{

    private int qtdNotificacoes; 

    public Professor(String nome, int codigo, IRegraEmprestimo regraEmprestimo ) {
        super(nome, codigo, regraEmprestimo, 7, Integer.MAX_VALUE);
        this.qtdNotificacoes=0;
    }

    @Override
    public void notificar(){
        this.qtdNotificacoes+=1;
    }

    @Override
    public int getQtdNotificacoes(){
        return this.qtdNotificacoes;
    }
}