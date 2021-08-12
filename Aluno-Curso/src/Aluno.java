

public class Aluno {
	private int id;

	  private String nome;

	  private String disciplina;

	  private float nota;

	  public Aluno() {

	  }

	  public Aluno( int id,String nome, String disciplina , int nota) {

	    setNome(nome);

	    setDisciplina(disciplina);

	    setNota(nota);

	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getNome() {
	    return nome;
	  } 
	  public void setNome(String nome) {
	    
	    if(nome.length() <= 100) {
	    
	      this.nome = nome;
	    
	    }
	    
	    else throw new RuntimeException("O nome deve ter no máximo 100 carateres");
	  } 

	  public String getDisciplina() {
	    return disciplina;
	  }

	  public void setDisciplina(String disciplina) {

	    if (disciplina.length() <= 50) {

	      this.disciplina = disciplina;

	    }

	    else throw new RuntimeException("A  disciplina deve ter no maxímo 50 carateres");

	  }


	  public float getNota() {
	    return nota;
	  }

	  public void setNota(float nota ) {

	    if (nota > 0 && nota < 10) {

	      this.nota = nota;

	    }

	    else throw new RuntimeException("A nota deve ser de 0 a 10");

	  }

	 

	  public String toString() {

	    String dados = "";
	    dados += "Id: " + this.id;
	    dados += "\nNome: " + this.nome;
	    dados += "\nDisciplina: " + this.disciplina;
	    dados += "\nNota: " + this.nota;


	    return dados;
	  }
}
