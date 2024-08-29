import java.util.List;
import java.util.ArrayList;

class Livro {
    
    private int codigo;
    private String titulo;
    private String editora;
    private String autores;
    private int edicao;
    private int anoPublicacao;
    private List<Exemplar> exemplares;

    public Livro(int codigo, String titulo, String editora, String autores, int edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<Exemplar>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }
    // Tem um erro de lógica aqui, o método deve buscar o exemplar pelo código do livro
    public boolean temExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                return true;
            }
        }
        return false;
    }

    public Exemplar emprestarExemplar() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                exemplar.setDisponivel(false);
                return exemplar;
            }
        }
        return null;
    }
}