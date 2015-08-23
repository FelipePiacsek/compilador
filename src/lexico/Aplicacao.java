package lexico;
public class Aplicacao {

	public static void main(String[] args) {
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		TabelaSimbolosTerminais tabela = repository.loadTable();
		tabela.print();
	}

}
