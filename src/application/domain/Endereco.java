package application.domain;

public class Endereco {
	private String rua;
	private String complemento;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
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
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Rua: " + getRua() + "\n");
		sb.append("Complemento: " + getComplemento() + "\n");
		sb.append("Cep: " + getCep() + "\n");
		sb.append("Cidade: " + getCidade() + "\n");
		sb.append("Estado" + getEstado() + "\n");
		
		return sb.toString();
	}
}
