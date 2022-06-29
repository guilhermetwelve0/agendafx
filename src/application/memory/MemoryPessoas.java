package application.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.domain.Pessoa;

public final class MemoryPessoas {

	private static ArrayList<Pessoa> memoryPessoa = new ArrayList<Pessoa>();
	private static Integer indexPessoaStage;

	public static ArrayList<Pessoa> getMemoryPessoa() {
		return memoryPessoa;
	}

	public static void setMemoryPessoa(List<Pessoa> memoryPessoa) {
		MemoryPessoas.memoryPessoa = (ArrayList<Pessoa>) memoryPessoa;
	}
	
	public static void setPessoa(Pessoa pessoa) {
		MemoryPessoas.memoryPessoa.add(pessoa);
	}
	
	public static Pessoa getPessoa(Integer index) {
		return MemoryPessoas.memoryPessoa.get(index);
	}

	public static Integer getIndexPessoaStage() {
		return indexPessoaStage;
	}

	public static void setIndexPessoaStage(Integer indexPessoaStage) {
		MemoryPessoas.indexPessoaStage = indexPessoaStage;
	}
}
