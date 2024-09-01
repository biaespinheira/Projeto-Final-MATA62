import java.util.List;
import java.util.Date;
import java.util.ArrayList;

abstract class Usuario {

  private int codigo; 
  private String nome;
  private int prazoDias;
  private int limiteLivros;
  private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
  private List<Emprestimo> emprestimosPassados = new ArrayList <Emprestimo> ();
  private IRegraEmprestimo regraEmprestimo;
  private List<Reserva> reservas = new ArrayList<Reserva>();
  private List<Reserva> reservasPassadas = new ArrayList <Reserva> ();

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

  public List<Emprestimo> getEmprestimosPassados(){
    return this.emprestimosPassados;
  }

  public List<Reserva> getReservas() {
      return reservas;
  }

  public List<Reserva> getReservasPassadas(){
    return this.reservasPassadas;
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
            this.reservasPassadas.add(reserva);
            break;
        }
      }
  }

  public IRegraEmprestimo getRegraEmprestimo(){
    return this.regraEmprestimo;
  }

  public boolean temEmprestimo(Livro livro){
    for (Emprestimo emprestimo : this.emprestimos){
        if (emprestimo.getExemplar().getLivro()==livro){
            return true;
        }
    }
    return false;
  }

  public int qtdReservas(){
    return this.reservas.size();
  }

  public void removerEmprestimo(Emprestimo emprestimoAntigo){
    for (Emprestimo emprestimo : emprestimos){
        if (emprestimo.equals(emprestimoAntigo)){
            this.emprestimos.remove(emprestimo);
            emprestimoAntigo.setDataDevolucao(new Date());
            this.emprestimosPassados.add(emprestimoAntigo);
            return;
        }
    }
  }

}
