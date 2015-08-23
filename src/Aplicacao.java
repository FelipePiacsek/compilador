



public class Aplicacao {

	public static void main(String[] args) {
		TabelaSimbolosTerminais tabela = new TabelaSimbolosTerminais();
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		tabela = repository.loadTable();
		tabela.print();
	}

}
