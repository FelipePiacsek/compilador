package lexico;
/**
 * Classe para teste da Tabela de S�mbolos Terminais.
 * @author FPiacsek
 */
public class Aplicacao {

	public static void main(String[] args) {
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		TabelaSimbolosTerminais tabela = repository.loadTable();
		tabela.print();
	}

}
