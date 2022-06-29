package application.domain;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;

public class Pessoa {
	private String nome;
	private String sobrenome;
	
	// pode ter varios contatos
	private ArrayList<Contato> contatos = new ArrayList<>();
	
	// construtor
	public Pessoa(String nome) {
		setNome(nome); 
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public ArrayList<Contato> getContatos() {
		return contatos;
	}
	
	// adciona uma lista de contatos
	public void setContatos(ArrayList<Contato> contatos) {
		this.contatos = contatos;
	}
	
	// adciona um unico contato
	public void setContato(Contato contato) {
		this.contatos.add(contato);
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Nome: " + getNome() + "\n");
		sb.append("Sobrenome: " + getSobrenome() + "\n");
		
		contatos.forEach(contato -> sb.append(contato.toString()));
		
		return sb.toString();
	}
}
