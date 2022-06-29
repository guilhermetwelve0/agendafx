package application.domain;

public class Contato {
	private String telefoneFixo;
	private String telefoneCelular;
	private String email;
	private String descricao;
	
	// relacionamento composição
	private Empresa empresa;
	private Endereco endereco;
	
	
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("======================================\n\n");
		sb.append("Telefone Fixo: " + getTelefoneFixo() + "\n");
		sb.append("Telefone Celular: " + getTelefoneCelular() + "\n");
		sb.append("Email: " + getEmail() + "\n");
		sb.append("Descrição: " + getDescricao() + "\n");
		
		if (getEndereco() != null) {
			sb.append(getEndereco().toString());
		}
		
		if (getEmpresa() != null) {
			sb.append(getEmpresa().toString());
		}
		sb.append("======================================\n\n");
		return sb.toString();
	}
}
