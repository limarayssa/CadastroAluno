package Modelos;

public class Alunos {

	//Declaração das variáveis
	private String nome;
	private int cpf;
	private String curso;
	private Endereco endereco;

	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Alunos() {
	}


	public Alunos(String dados) {
		
		//split quebra os dados conforme o parâmetro e separa eles, colocando dentro dessa matriz
		
		String [] atributos = dados.split(",");
		
		String [] nome = atributos[1].split("=");
		String [] cpf = atributos[2].split("=");
		String [] curso = atributos[3].split("=");
		
		Endereco enderecoAluno = new Endereco(atributos);
		
		//.trim desconsidera os espaços
		this.nome = nome [1].trim();
		this.cpf = Integer.parseInt(cpf [1].trim());
		this.curso = curso [1].trim();
		this.endereco = enderecoAluno; 
		
//		for (int x = 0; x< atributos.length;x++) 
//			System.out.println(atributos[x]);
		
	}


	//toString para apresentar os dados 
	@Override
	public String toString() {
		return "Aluno, nome= " + nome + ", CPF= " + cpf + ", Curso=" + curso + ", Rua=" + endereco + "";
	}




}
