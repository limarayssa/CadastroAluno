package Modelos;

public class Endereco {

	//Declaração das variáveis
	private String rua;
	private int num;
	private String bairro;
	private String cidade;
	private String estado;
	private int cep;

	//Getters and Setters
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return rua + ", " + num + ", " + bairro + ", " + cidade + ", "
				+ estado +  ", " + cep ;
	}

	public Endereco(String[] dadosEnd) {
		
		//.trim desconsidera os espaços
		String [] rua = dadosEnd[4].split("="); 
		this.rua = rua [1].trim();
		this.num = Integer.parseInt(dadosEnd[5].trim());
		this.bairro = dadosEnd [6].trim();
		this.cidade = dadosEnd [7].trim();
		this.estado = dadosEnd [8].trim();
		this.cep = Integer.parseInt(dadosEnd[9].trim());
	}

	public Endereco() {
	}

}
