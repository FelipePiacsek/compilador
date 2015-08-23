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
//		tabela.print();
		validateTable(tabela);
	}
	
	public static void validateTable(TabelaSimbolosTerminais tabela){
		TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
		List<String> palavras = repository.readFromFile();
		System.out.println(palavras.size() + " palavras.");
		List<String> erros = new ArrayList<String>();
		for (String palavra : palavras) {
			int i = tabela.insereBusca(palavra, CONSULTA);
			String s = tabela.getSimbolo(i);
			if(!s.equals(palavra)){	
				erros.add(palavra);
			}
		}
		if(erros.isEmpty()){
			System.out.println("Tabela funcionando corretamente!");
		}else{
			System.out.println("Tabela apresentando erro para o(s) seguinte(s) registro(s): ");
			for (String erro : erros) {
				System.out.println(erro);
			}
		}
	}

}
