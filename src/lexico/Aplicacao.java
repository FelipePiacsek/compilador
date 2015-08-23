package lexico;

import static lexico.TabelaSimbolosTerminais.Modo.CONSULTA;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe para teste da Tabela de Símbolos Terminais.
 * @author FPiacsek
 */
public class Aplicacao {

	public static void main(String[] args) {
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		TabelaSimbolosTerminais tabela = repository.loadTable();
		TabelaSimbolosTerminaisTeste teste = new TabelaSimbolosTerminaisTeste(tabela);
//		tabela.print();
		teste.validateTable();
	}
	


}
