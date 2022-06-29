package application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.domain.Contato;
import application.domain.Empresa;
import application.domain.Endereco;
import application.domain.Pessoa;
import application.memory.MemoryPessoas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class FormController implements Initializable{

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String acaoTela = "created";
	
	// componentes da tela
	@FXML
	protected Button btnCancelar;
	@FXML
	protected Button btnSalvar;
	@FXML
	protected TextField inpNome;
	@FXML
	protected TextField inpSobrenome;
	@FXML
	protected TextField inpTelefoneFixo;
	@FXML
	protected TextField inpTelefoneCelular;
	@FXML
	protected TextField inpEmail;
	@FXML
	protected TextField inpCep;
	@FXML
	protected TextField inpRua;
	@FXML
	protected TextField inpNumero;
	@FXML
	protected TextField inpComplemento;
	@FXML
	protected TextField inpBairro;
	@FXML
	protected TextField inpCidade;
	@FXML
	protected TextField inpEstado;
	@FXML
	protected TextField inpEmpresa;
	@FXML
	protected TextField inpObservacao;
	
	
	
	public void switchToList(ActionEvent event) {
		try {
			root  = FXMLLoader.load(getClass().getResource("List.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Boolean validaCamposObrigatorios() {
		if (inpNome.getText().isBlank() || inpNome.getText().isEmpty()) {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Atenção!");
			alerta.setHeaderText("Campos obrigatórios não foram preenchidos");
			alerta.setContentText("Nome é obrigatório!");
			alerta.show();
			return false;
		}
		return true;
	}
	
	
	public void salvarAction(ActionEvent event) {
		if (acaoTela.equals("created")) {
			created();
			this.switchToList(event);
		}
		if (acaoTela.equals("edited")) {
			edited();
		}
	}
	
	private void created() {
		if (validaCamposObrigatorios()) {
			// cria pessoa
			Pessoa pessoa = new Pessoa(inpNome.getText());
			pessoa.setSobrenome(inpSobrenome.getText());
			
			// cria contato
			Contato contato = new Contato();
			contato.setTelefoneFixo(inpTelefoneFixo.getText());
			contato.setTelefoneCelular(inpTelefoneCelular.getText());
			contato.setEmail(inpEmail.getText());
			contato.setDescricao(inpObservacao.getText());
			
			// verifica se existe empresa
			if (!inpEmpresa.getText().isEmpty()) {
				// cria empresa
				Empresa empresa = new Empresa();
				empresa.setNome(inpEmpresa.getText());
				contato.setEmpresa(empresa);
			}
			
			// cria endereco
			Endereco endereco = new Endereco();
			endereco.setCep(inpCep.getText());
			endereco.setRua(inpRua.getText());
			endereco.setNumero(inpNumero.getText());
			endereco.setComplemento(inpComplemento.getText());
			endereco.setBairro(inpBairro.getText());
			endereco.setCidade(inpCidade.getText());
			endereco.setEstado(inpEstado.getText());
			
			contato.setEndereco(endereco);
			
			pessoa.setContato(contato);
			
			// salva em memoria
			MemoryPessoas.setPessoa(pessoa);
			
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Sucesso!");
			alerta.setHeaderText("Contato cadastrado com sucesso!");
			alerta.show();			
		}
		
	}
	
	private void edited() {
		if (validaCamposObrigatorios()) {
			// cria pessoa
			Pessoa pessoa = new Pessoa(inpNome.getText());
			pessoa.setSobrenome(inpSobrenome.getText());
			
			// cria contato
			Contato contato = new Contato();
			contato.setTelefoneFixo(inpTelefoneFixo.getText());
			contato.setTelefoneCelular(inpTelefoneCelular.getText());
			contato.setEmail(inpEmail.getText());
			contato.setDescricao(inpObservacao.getText());
			
			// verifica se existe empresa
			if (!inpEmpresa.getText().isEmpty()) {
				// cria empresa
				Empresa empresa = new Empresa();
				empresa.setNome(inpEmpresa.getText());
				contato.setEmpresa(empresa);
			}
			
			// cria endereco
			Endereco endereco = new Endereco();
			endereco.setCep(inpCep.getText());
			endereco.setRua(inpRua.getText());
			endereco.setNumero(inpNumero.getText());
			endereco.setComplemento(inpComplemento.getText());
			endereco.setBairro(inpBairro.getText());
			endereco.setCidade(inpCidade.getText());
			endereco.setEstado(inpEstado.getText());
			
			contato.setEndereco(endereco);
			
			pessoa.setContato(contato);
			
			// salva em memoria
			MemoryPessoas.setPessoa(pessoa);
			
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Sucesso!");
			alerta.setHeaderText("Contato cadastrado com sucesso!");
			alerta.show();			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if (MemoryPessoas.getIndexPessoaStage() != null) {
			acaoTela = "edited";
			Pessoa p = MemoryPessoas.getPessoa(MemoryPessoas.getIndexPessoaStage());
			
			inpNome.setText(p.getNome());
		}
		
	}
}
