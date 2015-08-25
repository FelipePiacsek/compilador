package lexico;

import static lexico.TabelaSimbolosTerminais.Modo.CONSULTA;

import java.util.ArrayList;
import java.util.List;

public class TabelaSimbolosTerminaisTeste{

	private TabelaSimbolosTerminais tabela;
	
	private TabelaSimbolosTerminaisRepository repository;
	
	public TabelaSimbolosTerminaisTeste(TabelaSimbolosTerminais t) {
		this.tabela = t;
		repository = new TabelaSimbolosTerminaisRepository();
	}
	
	public void validateTable(){
		List<String> palavras = repository.readWordsFromTextFile();
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
