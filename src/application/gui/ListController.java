package application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.domain.Pessoa;
import application.memory.MemoryPessoas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ListController implements Initializable{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	// campos da tela
	@FXML
	private TableView<Pessoa> tabelaPessoas;
	
	public void switchToForm(ActionEvent event) {
		try {
			root  = FXMLLoader.load(getClass().getResource("Form.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void carregarDados() {	
		ObservableList<Pessoa> pessoaObservableList = FXCollections.observableArrayList(MemoryPessoas.getMemoryPessoa());
		this.tabelaPessoas.setItems(pessoaObservableList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		this.tabelaPessoas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		carregarDados();	
		MemoryPessoas.setIndexPessoaStage(null);
	}
	
	
	// quando clicar em uma linha da tabela retorna o item selecionado
	public void editaPessoa(ActionEvent event) {
		MemoryPessoas.setIndexPessoaStage(this.tabelaPessoas.getSelectionModel().getSelectedIndex());		
		this.switchToForm(event);
	}
	
}
