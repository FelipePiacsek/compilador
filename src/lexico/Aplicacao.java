package lexico;

/**
 * Classe para teste da Tabela de Símbolos Terminais.
 * @author FPiacsek
 */
public class Aplicacao {

	public static void main(String[] args) {
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		TabelaSimbolosTerminais tabela = repository.loadTable();
		TabelaSimbolosTerminaisTeste teste = new TabelaSimbolosTerminaisTeste(tabela);
		tabela.print();
		teste.validateTable();
	}
	


}
