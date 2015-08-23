package lexico;

import java.io.Serializable;

public class TabelaSimbolosTerminais implements Serializable {

	private static final long serialVersionUID = -6042272398374734123L;

	public static final int n = 113;

	private String simbolos[];

	private Integer indices[];

	public TabelaSimbolosTerminais() {
		indices = new Integer[2 * n + 20];
		simbolos = new String[2 * n + 20];
		simbolos[2 * n] = "ID";
		simbolos[2 * n + 1] = "NUMBER";
		simbolos[2 * n + 2] = "REAL";
		simbolos[2 * n + 3] = "ALPHA";
		simbolos[2 * n + 4] = "EOF";
	}

	private int getIndice(String cadeia) {
		int index = this.hash(cadeia);
		if (simbolos[index] == null) {
			return -1;
		}
		while (!simbolos[index].equals(cadeia)) {
			if(indices[index] == null){
				return -1;
			}
			index = indices[index];
		}
		return index;
	}

	private int putSimbolo(String simbolo) {
		int index = this.hash(simbolo);
		if (simbolos[index] == null) {
			simbolos[index] = simbolo;
			return index;
		}
		int sIndex = index;
		index += n;
		while (indices[sIndex] != null) {
			index = indices[sIndex];
			sIndex = index;
		}
		while (simbolos[index] != null) {
			index = n + ((index + 1) % n);
		}
		simbolos[index] = simbolo;
		indices[sIndex] = index;
		return index;
	}

	private int hash(String cadeia) {
		return Math.abs(cadeia.hashCode() % TabelaSimbolosTerminais.n);
	}

	public enum Modo {
		CONSULTA, INSERCAO;
	}

	public int insereBusca(String cadeia, Modo modo) {
		int index = 0;
		switch (modo) {
		case CONSULTA:
			index = this.getIndice(cadeia);
			break;
		case INSERCAO:
			index = this.putSimbolo(cadeia);
			break;
		}
		return index;

	}

	public void print() {
		System.out.println("Linha  Símbolo  Colisão");
		for (int i = 0; i < n * 2 + 20; i++) {
			System.out.println(i + "   " + simbolos[i] + "   " + indices[i]);
		}
	}

	public int count() {
		int c = 0;
		for (int i = 0; i < 2 * n; i++) {
			if (simbolos[i] != null) {
				c++;
			}
		}
		return c;
	}
}
