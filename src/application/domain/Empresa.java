package application.domain;

public class Empresa {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public String toString() {
		return "Nome Empresa: " + getNome() + "\n";
	}
}
