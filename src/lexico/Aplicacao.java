package lexico;

import static lexico.TabelaSimbolosTerminais.Modo.CONSULTA;

import java.util.List;


/**
 * Classe para teste da Tabela de Símbolos Terminais.
 * @author FPiacsek
 */
public class Aplicacao {

	public static void main(String[] args) {
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		TabelaSimbolosTerminais tabela = repository.loadTable();
		tabela.print();
	}
	
	public static void validateTable(TabelaSimbolosTerminais tabela){
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		List<String> palavras = repository.readFromFile();
		System.out.println(palavras.size() + " palavras.");
		for (String palavra : palavras) {
			int i = tabela.insereBusca(palavra, CONSULTA);
			System.out.println(i);
			if(i == -1){	
				System.out.println(palavra);
			}
		}
	}

}
